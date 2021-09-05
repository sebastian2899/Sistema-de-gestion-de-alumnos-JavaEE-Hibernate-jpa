package com.co.dao;

import com.co.domain.Domicilio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DomicilioDao {
    
    EntityManager entityManager = JPAUtil.geEntityManagerFactory().createEntityManager();
    
    public void insertarDomicilio(Domicilio domicilio){
        entityManager.getTransaction().begin();
        entityManager.persist(domicilio);
        entityManager.getTransaction().commit();
    }
    
    public List<Domicilio>listarDomicilios(){
        String hql = "select d from Domicilio d";
        Query query = entityManager.createQuery(hql);
        
        List<Domicilio>domicilios = query.getResultList();
        
        return domicilios;
    }
    
    public Domicilio encontrarDomicilio(Domicilio domicilio){
        return entityManager.find(Domicilio.class,domicilio.getIdDomicilio());
    }
    
    public void actualizarDomicilio(Domicilio domicilio){
        entityManager.getTransaction().begin();
        entityManager.merge(domicilio);
        entityManager.getTransaction().commit();
    }
    
    public void eliminarDomicilio(Domicilio domicilio){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(domicilio));
        entityManager.getTransaction().commit();
    }
    
}
