<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista alumnos</title>
    </head>
    <body>
        <h1>Listado de alumnos</h1>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletRegistrar">Ingresar alumno</a>
        <br/>
        <table border="1">
            <tr>
                <th>ID alumno</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
            <c:forEach items="${alumnos}" var="alumno" >
                <tr>
                    <td>
                    <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}"/>
                    ${alumno.idAlumno}
                    </td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>${alumno.domicilio.calle} ${alumno.domicilio.nCalle} ${alumno.domicilio.pais}</td>
                    <td>${alumno.contacto.email}</td>
                    <td>${alumno.contacto.telefono}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
    </body>
</html>
