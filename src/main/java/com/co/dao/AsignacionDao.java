package com.co.dao;

import com.co.domain.Asignacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AsignacionDao {
    
     EntityManager entityManager = JPAUtil.geEntityManagerFactory().createEntityManager();
    

    
    public void insertarAsignacion(Asignacion asignacion){
        entityManager.getTransaction().begin();
        entityManager.persist(asignacion);
        entityManager.getTransaction().commit();
    }
    
    public List<Asignacion>listarAsisnaciones(){
        String hql = "select a from Asignacion a";
        Query query = entityManager.createQuery(hql);
        
        List<Asignacion>asignaciones = query.getResultList();
        return asignaciones;
    }
    
      public Asignacion consultarAsignacionPorId(Asignacion asingacion){
       return entityManager.find(Asignacion.class,asingacion.getIdAsignacion());
    }

    
}
