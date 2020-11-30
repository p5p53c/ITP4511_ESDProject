<%-- 
    Document   : AccountList
    Created on : 2020年11月29日, 下午03:25:40
    Author     : p5p53
--%>

<%@page import="ict.bean.TechnicianBean"%>
<%@page import="ict.bean.StudentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <jsp:useBean id="memberlist" class="java.util.ArrayList<ict.bean.StudentBean>" scope="request" />
            <%
                for (int i = 0; i < memberlist.size();i++) {
                    StudentBean s = memberlist.get(i);
                    out.print("<tr>");
                    out.print("<td>" + s.getStudID() + "</td>");
                    out.print("<td>" + s.getName() + "</td>");
                    out.print("<td><a href=\"ListController?action=editStud&id=" + s.getStudID() + "\">edit</a> | ");
                    out.print("<a href=\"AccountController?action=delete&confirm=false&role=Student&id=" + s.getStudID() + "\">delete</a></td>");
                    out.println("</tr>");
                }
        %>
        </table>
        <a href="RoleSelect.jsp">Back</a>
    </body>
</html>
