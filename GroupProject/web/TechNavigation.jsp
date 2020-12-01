<%-- 
    Document   : TechNavigation
    Created on : 2020年12月1日, 下午03:22:32
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th><a href="TechMain.jsp">Home</a></th>
                <th><a href="ListController?action=techlist">Inventory management</a></th>
                <th><a href="ListController?action=techrequestlist">Borrowing request</a></th>
                <th><a href="ListController?action=techreturnlist">Return equipment</a></th>
            </tr>
        </table>
        <br>
        <br>
    </body>
</html>
