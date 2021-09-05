package com.co.dao;

import com.co.domain.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AlumnoDao {
    
    EntityManager entityManager =JPAUtil.geEntityManagerFactory().createEntityManager();
    
    public List<Alumno>listarAlumnos(){
        String hql = "select a from Alumno a";
        Query query = entityManager.createQuery(hql);
        List<Alumno>alumnos = query.getResultList();
        
        return alumnos;
    }
    
    public Alumno consultarAlumnoPorId(Alumno alumno){
       return entityManager.find(Alumno.class,alumno.getIdAlumno());
    }

    
    public void insertarAlumno(Alumno alumno){
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
    }
    
    public void actualizarAlumno(Alumno alumno){
        entityManager.getTransaction().begin();
        entityManager.merge(alumno);
        entityManager.getTransaction().commit();
    }
    
    public void eliminarAlumno(Alumno alumno){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(alumno));
        entityManager.getTransaction().commit();
    }
    
}
