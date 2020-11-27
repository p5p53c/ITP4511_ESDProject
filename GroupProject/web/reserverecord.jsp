<%-- 
    Document   : reserverecord
    Created on : Nov 27, 2020, 3:38:02 PM
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
        <jsp:useBean id="reserverecord" class="java.util.ArrayList<ict.bean.ReserveRecordBean>" scope="request" />
        <table border="1">
            <tr>
                <th>equipment name</th>
                <th>Borrow Status</th>
                <th>Application Date</th>
                <th>Borrow Date</th>
                <th>Return Date</th>
                <th>Actual Return Date</th>
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
                    
                    out.println("<tr><td>" + rr.getEquipname() + "</td><td>" + rr.getBorrowstatus() + "</td><td>" + rr.getApplication() + "</td><td>" + rr.getBorrow() + "</td><td>" + rr.getReturnTime() + "</td><td>" + rr.getActual() + "</td></tr>");
                }
            %>
        </table>
        <a href="StudentMain.jsp">Back</a>
    </body>
</html>
