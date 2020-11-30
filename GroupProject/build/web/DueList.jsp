<%-- 
    Document   : DueList
    Created on : 2020年11月28日, 下午09:15:38
    Author     : p5p53
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
        <jsp:useBean id="reserverecord" class="java.util.ArrayList<ict.bean.ReserveRecordBean>" scope="request" />
        <table border="1">
            <tr>
                <th>Equipment Name</th>
                <th>Student Name</th>
                <th>Borrow Time</th>
                <th>Return Time</th>
            </tr>
            <% 
                for (int i = 0; i < reserverecord.size(); i++) {
                    ReserveRecordBean rr = reserverecord.get(i);
                    
                    out.print("<tr>");
                    out.print("<td>" + rr.getEquipname() + "</td>");
                    out.print("<td>" + rr.getStudname()+ "</td>");
                    out.print("<td>" + rr.getBorrow() + "</td>");
                    out.print("<td>" + rr.getReturnTime() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="TechMain.jsp">Back</a>
    </body>
</html>
