<%-- 
    Document   : TechAccountList
    Created on : 2020年11月29日, 下午04:38:14
    Author     : p5p53
--%>

<%@page import="ict.bean.TechnicianBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="SeniorNavigation.jsp" />
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <jsp:useBean id="memberlist" class="java.util.ArrayList<ict.bean.TechnicianBean>" scope="request" />
            <%
                for (int i = 0; i < memberlist.size();i++) {
                    TechnicianBean s = memberlist.get(i);
                    out.print("<tr>");
                    out.print("<td>" + s.getTechID() + "</td>");
                    out.print("<td>" + s.getName() + "</td>");
                    out.print("<td><a href=\"ListController?action=editTech&id=" + s.getTechID() + "\">edit</a> | ");
                    out.print("<a href=\"AccountController?action=delete&confirm=false&role=Tech&id=" + s.getTechID() + "\">delete</a> | ");
                    out.print("<a href=\"AccountController?action=upgrade&confirm=false&id=" + s.getTechID() + "\">Upgrade to Senior</a></td>");
                    out.println("</tr>");
                }
        %>
        </table>
        <a href="RoleSelect.jsp">Back</a>
    </body>
</html>
