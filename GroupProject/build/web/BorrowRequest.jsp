<%-- 
    Document   : BorrowRequest
    Created on : 2020年11月28日, 下午04:02:51
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
        <jsp:include page="TechNavigation.jsp" />
        <jsp:useBean id="reserverecord" class="java.util.ArrayList<ict.bean.ReserveRecordBean>" scope="request" />
        <table border="1">
            <tr>
                <th>equipment name</th>
                <th>Application Date</th>
                <th>Student Name</th>
                <th>Action</th>
            </tr>
            <%
                for (int i = 0; i < reserverecord.size(); i++) {
                    ReserveRecordBean rr = reserverecord.get(i);
                    
                    out.print("<tr>");
                    out.print("<td>" + rr.getEquipname() + "</td>");
                    out.print("<td>" + rr.getApplication() + "</td>");
                    out.print("<td>" + rr.getStudname()+ "</td>");
                    out.print("<td><a href=\"ReserveControll?action=A&id=" + rr.getBorrowID() + "\"> Accept</a> |");
                    out.print("<a href=\"ReserveControll?action=R&id=" + rr.getBorrowID() + "\"> Reject </td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href="TechMain.jsp">Back</a>
    </body>
</html>
