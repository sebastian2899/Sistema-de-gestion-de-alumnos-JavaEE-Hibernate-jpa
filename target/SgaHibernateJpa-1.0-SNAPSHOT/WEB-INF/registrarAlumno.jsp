<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro alumnos</title>
    </head>
    <body>
        <h1>Registro de alumno</h1>
        <form action="${pageContext.request.contextPath}/ServletAgregar" method="post">
            Nombre <input type="text" name="nombre"/>
            <br/>
            Apellido <input type="text" name="apellido"/>
            <br/>
            <br/> 
            Datos Domicilio:
            <br/>
            Calle <input type="text" name="calle"/>
            <br/>
            No.Calle <input type="text" name="noCalle"/>
            <br/>
            Pais <input type="text" name="pais"/>
            <br/>
            <br/>
            Datos Contacto:
            <br/>
            Email <input type="email" name="email"/>
            <br/>
            Telefono <input type="tel" name="telefono"/>
            <br/>
            <input type="submit" name="registrar" value="Registrar">
            <br/>
            <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
        </form>
    </body>
</html>
