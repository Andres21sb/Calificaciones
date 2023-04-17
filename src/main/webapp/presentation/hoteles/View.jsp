<%-- 
    Document   : View
    Created on : 16 abr 2023, 08:07:36
    Author     : ESCINF
--%>

<%@page import="com.progra.calificaciones.logic.Hotel"%>
<%@page import="com.progra.calificaciones.presentation.hoteles.Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
    Model model = (Model) request.getAttribute("model");
    List<Hotel> hoteles = model.getHoteles();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/presentation/Head.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form name="form" action="presentation/hoteles/search" method="post">
                <div class="form-input">
                    <label for="Nombre">Nombre:</label>
                    <input type="text" Nombre="Nombre" name="Nombre" required>
                </div>
                <input type="submit" value="Buscar">
            </form>
           <a href="presentation/hoteles/show">Top 3</a>
        </div>
                <table>
            <thead> 
                <tr> 
                    <td> img </td><td> Hotel </td> <td> Calificacion </td>
                    <td> Add </td>
                </tr>
            </thead>

            <tbody>
                <% for(Hotel h: hoteles){%>
                <tr>
                    <td><img src="images/"+<%=h.getId()%>> </td><td> <%=h.getNombre()%> </td> <td> <%=h.calificacion()%> </td> 
                    <td> 
                        <form name="form" action="presentation/calificacion/show" method="post">
                            <div class="form-input">
                                <input type = "hidden" name="Id" value="<%=h.getId()%>">
                                <input type="submit" value="Add calificacion">
                            </div>
                        </form>
                    </td>
                </tr>

                <%}%>
            </tbody>

        </table>
        
    </body>
</html>
