package test;

import com.co.dao.AlumnoDao;
import com.co.dao.AsignacionDao;
import com.co.domain.Alumno;
import com.co.domain.Asignacion;
import com.co.domain.Contacto;
import com.co.domain.Domicilio;
import java.util.List;

public class Test {
    public static void main(String [] args){
        
        AlumnoDao alumnoDao = new AlumnoDao();
        Alumno alumno = new Alumno();
        
        List<Alumno>alumnos = alumnoDao.listarAlumnos();
        for(Alumno a: alumnos){
            System.out.println(a);
        }
    }
}
