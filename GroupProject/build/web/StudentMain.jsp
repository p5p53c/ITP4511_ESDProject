<%-- 
    Document   : welcome
    Created on : 2020年11月26日, 下午06:02:59
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Main</title>
    </head>
    <body>
        <jsp:useBean id="userInfo" class="ict.bean.StudentBean" scope="session" />
        <h1>Hello, <jsp:getProperty name="userInfo" property="name" /></h1>
        <p>Welcome to the IVPET Borrowing System</p>
        <ul>
            <ol><a href="ListController?action=studlist">Equipment reservation</a></ol>
            <ol><a href="ReserveControll?action=reserverecord">Check personal borrowing records</a></ol>
        </ul>
        <form method="post" action="main">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
    </body>
</html>
