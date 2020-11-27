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
        <title>Equipment List</title>
    </head>
    <body>
        <jsp:useBean id="userInfo" class="ict.bean.StudentBean" scope="session" />
        <jsp:useBean id="equipment" class="java.util.ArrayList<ict.bean.EquipmentBean>" scope="request" />
        <input type="hidden" name="studid" value="<jsp:getProperty name="userInfo" property="studID" />">
        <table border = "1">
            <tr>
                <th>Equipment Name</th>
                <th>Available Number</th>
                <th></th>
            </tr>
                <%
                    for (int i = 0; i < equipment.size(); i++) {
                        EquipmentBean e = equipment.get(i);
                        if (e.getAvaqty() > 0) 
                            out.println("<tr><td>" + e.getName() + "</td><td>" + e.getAvaqty() + "</td><td><a href=\"ReserveControll?action=reserve&id=" + e.getEquipmentID() + "\">Borrow</a></td></tr>");
                        else
                            out.println("<tr><td>" + e.getName() + "</td><td>" + e.getAvaqty() + "</td><td>Borrow</td></tr>");
                    }
                %>
        </table>
        <a href="/GroupProject/StudentMain.jsp">Back</a>
    </body>
</html>
