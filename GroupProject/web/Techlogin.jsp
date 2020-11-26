<%-- 
    Document   : stafflogin
    Created on : 2020年11月26日, 下午04:00:24
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technician Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="post" action="main">
            <input type="hidden" name="action" value="authenticate" />
            <input type="hidden" name="identity" value="Tech">
            <table>
                <tr>
                    <td>Technician ID : </td>
                    <td><input type="text" name="ID"></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><input type="password" name="pwd"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit">
                    </td>
                </tr>
            </table>
            <a href="index.jsp">Press here to login Student account</a><br>
            <a href="Seniorlogin.jsp">Press here to login Senior Technician account</a>            
        </form>
    </body>
</html>
