<%-- 
    Document   : BorrowRecord
    Created on : 2020年11月28日, 下午10:58:51
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
                <th>Equipment name</th>
                <th>Student Name</th>
                <th>Borrow Status</th>
                <th>Application Date</th>
                <th>Borrow Date</th>
                <th>Return Date</th>
                <th>Actual Return Date</th>
                <th>Dealer</th>
            </tr>
            <%
                for (int i = 0; i < reserverecord.size(); i++) {
                    ReserveRecordBean rr = reserverecord.get(i);
                    
                    if (rr.getBorrowstatus().equals("A"))
                        rr.setBorrowstatus("Accept");
                    else if (rr.getBorrowstatus().equals("W"))
                        rr.setBorrowstatus("Waiting for acceptance");
                    else if (rr.getBorrowstatus().equals("R"))
                        rr.setBorrowstatus("Reject");
                    
                    out.print("<tr>");
                    out.print("<td>" + rr.getEquipname() + "</td>");
                    out.print("<td>" + rr.getStudname() + "</td>");
                    out.print("<td>" + rr.getBorrowstatus() + "</td>");
                    out.print("<td>" + rr.getApplication() + "</td>");
                    out.print("<td>" + rr.getBorrow() + "</td>");
                    out.print("<td>" + rr.getReturnTime() + "</td>");
                    out.print("<td>" + rr.getActual() + "</td>");
                    out.print("<td>" + rr.getTechname() + "</td>");
                    out.print("</tr>");
                }
            %>
        </table>
        <a href="SeniorMain.jsp">Back</a>
    </body>
</html>
