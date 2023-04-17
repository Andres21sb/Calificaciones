<%-- 
    Document   : Header
    Created on : 16 abr 2023, 11:01:58
    Author     : ESCINF
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Header</title>
        <style>
            <%@include file="/css/style.css" %>
        </style>
    </head>

    <body>
        <header> 


            
            <div class="logo">
                <img src="images/logo.png" alt="Logo de mi sitio web">
            </div> 


            <% if (cliente==null){%>
            <nav>
                <ul>
                    <li><a href="presentation/login/show">Login</a></li>
                    <li><a href="#">Acerca de</a></li>
                    <li><a href="#">Contacto</a></li>
                </ul>
            </nav>
            <% } %>
            
            
        </header>
    </body>
</html>
