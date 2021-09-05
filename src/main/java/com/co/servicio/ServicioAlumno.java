package com.co.servicio;

import com.co.dao.AlumnoDao;
import com.co.domain.Alumno;
import java.util.List;

public class ServicioAlumno {
    
    AlumnoDao alumnoDao = new AlumnoDao();
    
    public void guardarAlumno(Alumno alumno){
        if (alumno!=null && alumno.getIdAlumno()==null) {
            alumnoDao.insertarAlumno(alumno);
        }else{
            alumnoDao.actualizarAlumno(alumno);
        }
    }
    
    public List<Alumno>listarAlumnos(){
       return this.alumnoDao.listarAlumnos();
    }
    
    public Alumno consultarAlumno(Alumno alumno){
        return alumnoDao.consultarAlumnoPorId(alumno);
    }

    public void eliminarAlumno(Alumno alumno){
        alumnoDao.eliminarAlumno(alumno);
    }
}
