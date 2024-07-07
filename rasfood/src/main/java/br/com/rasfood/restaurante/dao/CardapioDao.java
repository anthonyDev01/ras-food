package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: " + cardapio);
    }

    public Cardapio consultar(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
