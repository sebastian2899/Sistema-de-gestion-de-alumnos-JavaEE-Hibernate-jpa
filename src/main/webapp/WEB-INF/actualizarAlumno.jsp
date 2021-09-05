<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro alumnos</title>
    </head>
    <body>
        <h1>Registro de alumno</h1>
        <form action="${pageContext.request.contextPath}/ServletModificar" method="post">
            <input type="hidden" name="idAlumno" value="${alumno.idAlumno}"/>
            Nombre <input type="text" name="nombre" value="${alumno.nombre}"/>
            <br/>
            Apellido <input type="text" name="apellido" value="${alumno.apellido}"/>
            <br/>
            <br/> 
            Datos Domicilio:
            <br/>
            Calle <input type="text" name="calle" value="${alumno.domicilio.calle}"/>
            <br/>
            No.Calle <input type="text" name="noCalle" value="${alumno.domicilio.nCalle}"/>
            <br/>
            Pais <input type="text" name="pais" value="${alumno.domicilio.pais}"/>
            <br/>
            <br/>
            Datos Contacto:
            <br/>
            Email <input type="email" name="email" value="${alumno.contacto.email}"/>
            <br/>
            Telefono <input type="tel" name="telefono" value="${alumno.contacto.telefono}"/>
            <br/>
            <input type="submit" name="actualizar" value="Actualizar">
            <input type="submit" name="eliminar" value="Eliminar Alumno">
            <br/>
            <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
        </form>
    </body>
</html>
