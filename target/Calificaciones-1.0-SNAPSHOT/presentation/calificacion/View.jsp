<%-- 
    Document   : View
    Created on : 16 abr 2023, 09:42:30
    Author     : ESCINF
--%>

<%@page import="com.progra.calificaciones.logic.Hotel"%>
<%@page import="com.progra.calificaciones.presentation.calificacion.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    Hotel h = model.getCurrent();
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calificacion</h1>
        <form name="form" action="/Calificaciones/presentation/calificacion/calificar" method="post"> 

            <div class="container">

                <label for="nombre">Calificacion Hotel: <%=h.getNombre()%></label>

                <label for="nombre">Nombre:</label>
                <input type="text" id="Nombre" placeholder="Nombre" type="text" name="Nombre">


                <label for="nombre">Comentario: </label>
                <input type="text" id="Comentario" placeholder="Comentario" name="Comentario" required>

                <label for="Calificacion">Calificacion:</label><br>
                <input type="radio" id="1x" name="Puntaje" value="1">
                <label for="1x">1x</label><br>
                <input type="radio" id="2x" name="Puntaje" value="2">
                <label for="2x">2x</label><br>
                <input type="radio" id="3x" name="Puntaje" value="3">
                <label for="3x">3x</label><br>
                <input type="radio" id="4x" name="Puntaje" value="4">
                <label for="4x">4x</label><br>
                <input type="radio" id="5x" name="Puntaje" value="5">
                <label for="5x">5x</label><br>

                <input type="submit" value="Aplicar">
            </div>
        </form>
    </body>
</html>
