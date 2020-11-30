<%-- 
    Document   : SeniorMain
    Created on : 2020年11月26日, 下午06:45:07
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Senior Technician Main</title>
    </head>
    <body>
         <jsp:useBean id="userInfo" class="ict.bean.SeniorBean" scope="session" />
        <h1>Hello, <jsp:getProperty name="userInfo" property="name" /></h1>
        <p>Welcome to the IVPET Borrowing System</p>
        <ul>
            <ol><a href="ListController?action=techborrowlist">Borrowing Record</a></ol>
            <ol><a href="AccountManage.jsp">Account management</a></ol>
            <ol><a href="UtilizationInput.jsp">Equipment utilization rate</a></ol>
        </ul>
        <form method="post" action="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
    </body>
</html>
