<%-- 
    Document   : TechMain
    Created on : 2020年11月26日, 下午06:44:54
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Technician Main</title>
    </head>
    <body>
         <jsp:useBean id="userInfo" class="ict.bean.TechnicianBean" scope="session" />
        <h1>Hello, <jsp:getProperty name="userInfo" property="name" /></h1>
        <p>Welcome to the IVPET Borrowing System</p>
        <ul>
            <ol><a href="ListController?action=techlist">Inventory management</a></ol>
            <ol><a href="ListController?action=techrequestlist">Borrowing request</a></ol>
            <ol>Handle check-in/out of equipment</ol>
            <ol>Lookup overdue items</ol>
            <%
                int due = Integer.parseInt(session.getAttribute("due").toString());
                if (due > 0) {
                    out.print("<ol><p style=\"color:red\">" + due + " equipment haven't return</p></ol>");
                }
            %>
        </ul>
        <form method="post" action="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
    </body>
</html>
