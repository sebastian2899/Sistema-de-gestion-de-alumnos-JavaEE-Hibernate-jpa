package com.co.dao;

import com.co.domain.Contacto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ContactoDao {
    
    EntityManager entityManager = JPAUtil.geEntityManagerFactory().createEntityManager();
    
    public void insertarContacto(Contacto contacto){
        entityManager.getTransaction().begin();
        entityManager.persist(contacto);
        entityManager.getTransaction().commit();
    }
    
    public List<Contacto> listarContacto(){
        String hql = "select c from Contacto c";
        Query query = entityManager.createQuery(hql);
        List<Contacto>contactos = query.getResultList();
        
        return contactos;
    }
    
    public void actualizarContacto(Contacto contacto){
        entityManager.getTransaction().begin();
        entityManager.merge(contacto);
        entityManager.getTransaction().commit();
    }
    
    public void eliminarContacto(Contacto contacto){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(contacto));
        entityManager.getTransaction().commit();
    }
    
    public Contacto consultarContacto(Contacto contacto){
        return entityManager.find(Contacto.class,contacto.getIdContacto());
    }
    
}
