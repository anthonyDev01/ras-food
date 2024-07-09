package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria buscarPorId(final Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> buscarTodos(){
        String sql = "SELECT c from Categoria c";
        return this.entityManager.createQuery(sql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void  deletar(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
