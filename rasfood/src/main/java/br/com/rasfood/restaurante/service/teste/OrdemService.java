package br.com.rasfood.restaurante.service.teste;

import br.com.rasfood.restaurante.dao.CardapioDao;
import br.com.rasfood.restaurante.dao.ClienteDao;
import br.com.rasfood.restaurante.dao.OrdemDao;
import br.com.rasfood.restaurante.entity.Cliente;
import br.com.rasfood.restaurante.entity.Ordem;
import br.com.rasfood.restaurante.entity.OrdensCardapio;
import br.com.rasfood.restaurante.util.CargaDeDadosUtil;
import br.com.rasfood.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutoCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Cliente felipe = new Cliente("38308386874", "Jorge", "000000");
        Ordem ordem = new Ordem(felipe);
        ordem.addOrdensCardapio(new OrdensCardapio(ordem, cardapioDao.consultarPorID(1), 2));

        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
