<%-- 
    Document   : Seniorlogin
    Created on : 2020年11月26日, 下午05:52:16
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Senior Technician Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="post" action="main">
            <input type="hidden" name="action" value="authenticate" />
            <input type="hidden" name="identity" value="STech">
            <table>
                <tr>
                    <td>Senior Technician ID : </td>
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
            <a href="Techlogin.jsp">Press here to login Technician account</a>        
        </form>
    </body>
</html>
