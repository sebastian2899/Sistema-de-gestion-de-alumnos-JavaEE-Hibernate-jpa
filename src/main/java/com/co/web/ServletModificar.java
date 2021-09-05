package com.co.web;

import com.co.domain.Alumno;
import com.co.servicio.ServicioAlumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idAlumnos = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnos);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.consultarAlumno(alumno);

        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/actualizarAlumno.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServicioAlumno alumnoService = new ServicioAlumno();

        String modificar = request.getParameter("actualizar");

        if (modificar != null) {

            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);

            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setnCalle(noCalle);
            alumno.getDomicilio().setPais(pais);

            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            alumnoService.guardarAlumno(alumno);
            sesion.removeAttribute("alumno");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }else{
            
            String idAlumno = request.getParameter("idAlumno");
            Integer idAlum = Integer.parseInt(idAlumno);
            
            Alumno alumno = new Alumno(idAlum);
            alumnoService.eliminarAlumno(alumno);
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }

    }

}
