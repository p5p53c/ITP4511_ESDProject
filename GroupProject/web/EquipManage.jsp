<%-- 
    Document   : EquipManage
    Created on : 2020年11月27日, 下午06:41:55
    Author     : p5p53
--%>

<%@page import="ict.bean.EquipmentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipment List</title>
    </head>
    <body>
        <jsp:useBean id="equipment" class="java.util.ArrayList<ict.bean.EquipmentBean>" scope="request" />
        <table border = "1">
            <tr>
                <th>Equipment Name</th>
                <th>Total Number</th>
                <th>Available Number</th>
                <th>Action</th>
            </tr>
                <%
                    for (int i = 0; i < equipment.size(); i++) {
                        EquipmentBean e = equipment.get(i);
                        out.println("<tr>");
                        out.println("<td>" + e.getName() + "</td>");
                        out.println("<td>" + e.getQty() + "</td>");
                        out.println("<td>" + e.getAvaqty() + "</td>");
                        out.println("<td><a href=\"ListController?action=editEquip&id=" + e.getEquipmentID() + "\">edit</a> | ");
                        out.println("<a href=\"EquipController?action=delete&confirm=false&id=" + e.getEquipmentID() + "\">delete</a></td>");
                        out.println("</tr>");
                    }
                %>
        </table>
        <a href="EquipEdit.jsp">Create Equipment</a>
        <a href="TechMain.jsp">Back</a>
    </body>
</html>
