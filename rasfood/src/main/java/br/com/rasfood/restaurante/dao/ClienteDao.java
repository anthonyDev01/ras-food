package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Cardapio;
import br.com.rasfood.restaurante.entity.Cliente;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Cliente cliente){
        this.entityManager.persist(cliente);
        System.out.println("Entidade cadastrada: " + cliente);
    }

    public Cliente consultarPorID(final Integer id){
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos(){
        try {
            String jpql = "SELECT c FROM Cliente c";
            return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Cliente> consultarPorValor(final BigDecimal valor){
        try {
            String jpql = "SELECT c from Cliente c where c.valor = :valor";
            return this.entityManager.createQuery(jpql, Cliente.class).setParameter("valor", valor).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }

    }

    public Cliente consultarPorNome(final String filtro){
        try {
            String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cliente.class).setParameter("nome", filtro).getSingleResult();

        }catch (Exception e){
            return null;
        }

    }

    public void atualizar(final Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente){
        this.entityManager.remove(cliente);
    }
}
