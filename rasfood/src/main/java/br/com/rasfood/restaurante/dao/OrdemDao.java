package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Cliente;
import br.com.rasfood.restaurante.entity.Ordem;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Ordem ordem){
        this.entityManager.persist(ordem);
        System.out.println("Entidade cadastrada: " + ordem);
    }

    public Ordem consultarPorID(final Integer id){
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos(){
        try {
            String jpql = "SELECT c FROM Ordem c";
            return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Ordem> consultarPorValor(final BigDecimal valor){
        try {
            String jpql = "SELECT c from Ordem c where c.valor = :valor";
            return this.entityManager.createQuery(jpql, Ordem.class).setParameter("valor", valor).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }

    }

    public Ordem consultarPorNome(final String filtro){
        try {
            String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Ordem.class).setParameter("nome", filtro).getSingleResult();

        }catch (Exception e){
            return null;
        }

    }

    public void atualizar(final Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem){
        this.entityManager.remove(ordem);
    }
}
