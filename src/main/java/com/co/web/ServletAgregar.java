package com.co.web;

import com.co.domain.Alumno;
import com.co.domain.Contacto;
import com.co.domain.Domicilio;
import com.co.servicio.ServicioAlumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServicioAlumno alumnoService = new ServicioAlumno();
        
        Alumno alumno = new Alumno();
        Contacto contacto = new Contacto();
        Domicilio domicilio = new Domicilio();
        
        String calle = request.getParameter("calle");
        domicilio.setCalle(calle);
        
        String noCalle = request.getParameter("noCalle");
        domicilio.setnCalle(noCalle);
        
        String pais = request.getParameter("pais");
        domicilio.setPais(pais);
        
        String email = request.getParameter("email");
        contacto.setEmail(email);
        
        String telefono = request.getParameter("telefono");
        contacto.setTelefono(telefono);
        
        String nombre = request.getParameter("nombre");
        alumno.setNombre(nombre);
        
        String apellido = request.getParameter("apellido");
        alumno.setApellido(apellido);
        
        alumno.setContacto(contacto);
        alumno.setDomicilio(domicilio);
        
        alumnoService.guardarAlumno(alumno);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

  
    
    
}
