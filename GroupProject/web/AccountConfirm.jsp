<%-- 
    Document   : AccountConfirm
    Created on : 2020年11月28日, 下午11:39:03
    Author     : p5p53
--%>

<%@page import="ict.bean.StudentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String type = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            String role = request.getParameter("role");
            String action;
            if (type.equals("Create") || type.equals("Edit"))
                action = "AccountController";
            else 
                action = "AccountController";
        %>
        <form action="<%=action%>" method="post">
            <input type="hidden" name="action" value="<%=type%>">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="name" value="<%=name%>">
            <input type="hidden" name="pwd" value="<%=pwd%>">
            <input type="hidden" name="role" value="<%=role%>">
            <input type="hidden" name="confirm" value="true">
            <%=type%> Account
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Role</th>
                </tr>
                <tr>
                    <td><%=name%></td>
                    <td><%=pwd%></td>
                    <%
                        if ("Tech".equalsIgnoreCase(role)) {
                            role = "Technician";
                        } else if ("STech".equalsIgnoreCase(role))
                            role = "Senior Technician";
                    %>
                    <td><%=role%></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Confirm">   <input type="button" value="Back" onclick="javascript:window.history.back()"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
