<%-- 
    Document   : confirm
    Created on : 2020年11月27日, 下午09:32:25
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
        <jsp:useBean id="e" scope="request" class="ict.bean.EquipmentBean" />
        <%
            String type = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int qty = Integer.parseInt(request.getParameter("qty"));
            String status = request.getParameter("status");
            String action;
            if (type.equals("Add") || type.equals("Edit"))
                action = "EquipController";
            else 
                action = "EquipController";
        %>
        <form action="<%=action%>">
            <input type="hidden" name="action" value="<%=type%>">
            <input type="hidden" name="id" value="<%=id%>">
            <input type="hidden" name="name" value="<%=name%>">
            <input type="hidden" name="qty" value="<%=qty%>">
            <input type="hidden" name="status" value="<%=status%>">
            <input type="hidden" name="confirm" value="true">
            <table border="1">
                <tr>
                    <% 
                        if (id != 0) 
                            out.println("<th>ID</th>");
                    %>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <% 
                        if (id != 0) 
                            out.println("<td>" + id + "</td>");
                    %>
                    <td><%=name%></td>
                    <td><%=qty%></td>
                    <td><%
                            if ("Delete".equalsIgnoreCase(type))
                                out.print("Delete");
                            else if ("N".equalsIgnoreCase(status))
                                out.print("Nonavailable");
                            else if ("A".equalsIgnoreCase(status))
                                out.print("Available");
                        %></td>
                </tr>
                <tr>
                    <td colspan="4"><input type="submit" value="Confirm">   <input type="button" value="Back" onclick="javascript:window.history.back()"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
