<%-- 
    Document   : Reservation
    Created on : 2020年11月26日, 下午09:06:27
    Author     : p5p53
--%>

<%@page import="ict.bean.EquipmentBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="userInfo" class="ict.bean.StudentBean" scope="session" />
        <jsp:useBean id="equipment" class="java.util.ArrayList<ict.bean.EquipmentBean>" scope="request" />
        <input type="hidden" name="id" value="<jsp:getProperty name="userInfo" property="studID" />">
        <table border = "1">
            <tr>
                <th>Equipment Name</th>
                <th>Available Number</th>
                <th></th>
            </tr>
                <%
                    for (int i = 0; i < equipment.size(); i++) {
                        EquipmentBean e = equipment.get(i);
                        out.println("<tr><td>" + e.getName() + "</td><td>" + e.getQty() + "</td><td>" + e.getEquipmentID() + "</td></tr>");
                    }
                %>
        </table>
    </body>
</html>
