package com.co.web;

import com.co.domain.Alumno;
import com.co.servicio.ServicioAlumno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        
        List<Alumno>alumnos = servicioAlumno.listarAlumnos();
        request.setAttribute("alumnos",alumnos);
        request.getRequestDispatcher("/WEB-INF/listadoAlumnos.jsp").forward(request, response);
    }
    
    
    
}
