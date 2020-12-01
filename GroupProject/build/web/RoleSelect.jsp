<%-- 
    Document   : RoleSelect
    Created on : 2020年11月29日, 下午03:16:54
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
        <jsp:include page="SeniorNavigation.jsp" />
        <ul>
            <ol><a href="ListController?action=stud">Student</a></ol>
            <ol><a href="ListController?action=tech">Technician</a></ol>
        </ul>
        <a href="SeniorMain.jsp">Back</a>
    </body>
</html>
