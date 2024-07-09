package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: " + cardapio);
    }

    public Cardapio consultarPorID(final Integer id){
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos(){
        try {
            String jpql = "SELECT c FROM Cardapio c";
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarPorValor(final BigDecimal valor){
        try {
            String jpql = "SELECT c from Cardapio c where c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", valor).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }

    }

    public Cardapio consultarPorNome(final String filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();

        }catch (Exception e){
            return null;
        }

    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
}
