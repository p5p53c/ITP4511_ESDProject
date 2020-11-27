<%-- 
    Document   : CheckReservationRecord
    Created on : Nov 27, 2020, 1:59:58 PM
    Author     : user
--%>

<%@page import="ict.bean.ReserveRecordBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Reservation Record</title>
    </head>
    <body>
        <jsp:useBean id="reserverecord" class="java.util.ArrayList<ict.bean.ReserveRecordBean>" scope="request" />
        <table border ="1">
            <tr>
                <th>Equipment Name</th>
                <th>Status</th>
                <th>Application Date</th>
                <th>Borrow Date</th>
                <th>Return Date</th>
                <th>Actual Return Date</th>
            </tr>
            <%
                for (int i = 0; i < reserverecord.size(); i++) {
                    ReserveRecordBean rr = reserverecord.get(i);
                    out.println("<tr><td>" + rr.getEquipName() + "</td><td>" + rr.getStatus() + "</td><td>" + rr.getApplication() + "</td><td>" + rr.getBorrow() + "</td><td>" + rr.getReturntime() + "</td><td>" + rr.getActual() + "</td></tr>");
                }
            %>
        </table>
    </body>
</html>
