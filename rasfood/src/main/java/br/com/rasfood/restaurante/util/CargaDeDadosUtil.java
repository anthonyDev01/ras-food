package br.com.rasfood.restaurante.util;

import br.com.rasfood.restaurante.dao.CardapioDao;
import br.com.rasfood.restaurante.dao.CategoriaDao;
import br.com.rasfood.restaurante.entity.Cardapio;
import br.com.rasfood.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {
    private CargaDeDadosUtil(){}

    public static void cadastrarCategoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        Categoria pratoPrincipal = new Categoria("Prato principal");
        Categoria entrada = new Categoria("Entrada");
        Categoria sobremesa = new Categoria("Sobremesa");

        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.flush();
        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(sobremesa);
        entityManager.flush();
        entityManager.clear();

    }

    public static void cadastrarProdutoCardapio(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.buscarTodos();

        Cardapio moqueca = new Cardapio("Moqueca", "Peixe branco, banana da terra, arroz e farofa", true, BigDecimal.valueOf(96.00), categorias.get(2));
        Cardapio feijoada = new Cardapio("Feijoada", "Feijão preto, carne seca, linguiça, arroz, couve e farofa", true, BigDecimal.valueOf(85.00), categorias.get(1));
        Cardapio acaraje = new Cardapio("Acarajé", "Bolinho de feijão fradinho, vatapá, caruru, camarão seco", true, BigDecimal.valueOf(50.00), categorias.get(2));
        Cardapio vatapa = new Cardapio("Vatapá", "Pão, camarão, amendoim, castanha de caju, leite de coco e dendê", true, BigDecimal.valueOf(70.00), categorias.get(2));
        Cardapio carneDeSol = new Cardapio("Carne de Sol", "Carne de sol, aipim frito, arroz de leite e farofa", true, BigDecimal.valueOf(90.00), categorias.get(1));
        Cardapio escondidinho = new Cardapio("Escondidinho", "Purê de mandioca, carne seca desfiada, queijo coalho", true, BigDecimal.valueOf(70.00), categorias.get(1));
        Cardapio camaraoNaMoranga = new Cardapio("Camarão na Moranga", "Camarão, abóbora, requeijão cremoso, arroz", true, BigDecimal.valueOf(120.00), categorias.get(2));
        Cardapio baiaoDeDois = new Cardapio("Baião de Dois", "Arroz, feijão verde, carne seca, queijo coalho, coentro", true, BigDecimal.valueOf(65.00), categorias.get(1));
        Cardapio galinhaCaipira = new Cardapio("Galinha Caipira", "Galinha caipira, arroz, pirão, batata doce", true, BigDecimal.valueOf(80.00), categorias.get(1));
        Cardapio sarapatel = new Cardapio("Sarapatel", "Miúdos de porco, sangue coagulado, pimentão, cebola, tomate", true, BigDecimal.valueOf(60.00), categorias.get(1));

        cardapioDao.cadastrar(moqueca);
        cardapioDao.cadastrar(feijoada);
        cardapioDao.cadastrar(acaraje);
        cardapioDao.cadastrar(vatapa);
        cardapioDao.cadastrar(carneDeSol);
        cardapioDao.cadastrar(escondidinho);
        cardapioDao.cadastrar(camaraoNaMoranga);
        cardapioDao.cadastrar(baiaoDeDois);
        cardapioDao.cadastrar(galinhaCaipira);
        cardapioDao.cadastrar(sarapatel);

        entityManager.flush();
        entityManager.clear();

    }
}
