package br.com.rasfood.restaurante.service.teste;

import br.com.rasfood.restaurante.dao.CardapioDao;
import br.com.rasfood.restaurante.dao.CategoriaDao;
import br.com.rasfood.restaurante.entity.Cardapio;
import br.com.rasfood.restaurante.entity.Categoria;
import br.com.rasfood.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }

    private static Categoria cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponivel(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracujá");
        salmao.setDisponivel(true);
        salmao.setCategoria(categoria);
        salmao.setValor(BigDecimal.valueOf(60.50));



        CardapioDao pratoDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();

        pratoDao.cadastrar(risoto);
        entityManager.flush();

        pratoDao.cadastrar(salmao);
        entityManager.flush();

        System.out.println("O prato consultado foi " + pratoDao.consultar(1));
        System.out.println("O prato consultado foi " + pratoDao.consultar(2));

        entityManager.close();

    }
}
