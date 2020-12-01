<%-- 
    Document   : ReturnList
    Created on : Nov 30, 2020, 11:33:15 AM
    Author     : user
--%>

<%@page import="ict.bean.ReserveRecordBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="TechNavigation.jsp" />
        <jsp:useBean id="reserverecord" class="java.util.ArrayList<ict.bean.ReserveRecordBean>" scope="request" />
        <table border="1">
            <tr>
                <th>Borrow ID</th>
                <th>Equipment Name</th>
                <th>Student Name</th>
                <th>Return Time</th>
                <th>Action</th>
            </tr>
            <% 
                for (int i = 0; i < reserverecord.size(); i++) {
                    ReserveRecordBean rr = reserverecord.get(i);
                    
                    out.print("<tr>");
                    out.print("<td>" + rr.getBorrowID() + "</td>");
                    out.print("<td>" + rr.getEquipname() + "</td>");
                    out.print("<td>" + rr.getStudname()+ "</td>");
                    out.print("<td>" + rr.getReturnTime() + "</td>");
                    out.print("<td><a href=\"ReserveControll?action=return&id=" + rr.getBorrowID() + "\">Return</a></td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="TechMain.jsp">Back</a>
    </body>
</html>
