package br.com.rasfood.restaurante.dao;

import br.com.rasfood.restaurante.entity.Cardapio;
import br.com.rasfood.restaurante.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Categoria buscar(final Integer id){
        return this.entityManager.find(Categoria.class, id);
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void  deletar(final Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
