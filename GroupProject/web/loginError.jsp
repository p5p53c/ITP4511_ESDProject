<%-- 
    Document   : loginError
    Created on : Oct 30, 2020, 2:02:34 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Error</title>
    </head>
    <body>
        <p>Incorrect Password</p>
        <p>
            <% out.println("<a href=\"" + request.getContextPath() + "/index.jsp\">Login again</a>"); %>
        </p>
    </body>
</html>
