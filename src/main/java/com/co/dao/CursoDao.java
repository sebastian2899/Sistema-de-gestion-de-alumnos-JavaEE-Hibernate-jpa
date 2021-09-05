package com.co.dao;

import com.co.domain.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CursoDao {
    
    EntityManager entityManager = JPAUtil.geEntityManagerFactory().createEntityManager();
    
    public void insertarCurso(Curso curso){
        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
    }
    
    public List<Curso>listarCursos(){
        String hql = "select c from Curso c";
        Query query = entityManager.createQuery(hql);
        
        List<Curso>cursos = query.getResultList();
        return cursos;
    }
    
    public void acutalizarCurso(Curso curso){
        entityManager.getTransaction().begin();
        entityManager.merge(curso);
        entityManager.getTransaction().commit();
    }
    
     public void eliminarCurso(Curso curso){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(curso));
        entityManager.getTransaction().commit();
    }
}
