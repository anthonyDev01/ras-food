package br.com.rasfood.restaurante.service.teste;

import br.com.rasfood.restaurante.dao.CardapioDao;
import br.com.rasfood.restaurante.dao.CategoriaDao;
import br.com.rasfood.restaurante.entity.Cardapio;
import br.com.rasfood.restaurante.entity.Categoria;
import br.com.rasfood.restaurante.util.CargaDeDadosUtil;
import br.com.rasfood.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        //System.out.println("Lista de produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(70.00)));
        System.out.println("O produto pesquisado foi: " + cardapioDao.consultarPorNome("Carne de Sol"));

        entityManager.close();
    }


}
