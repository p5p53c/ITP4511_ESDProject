<%-- 
    Document   : UtilizationInput
    Created on : 2020年11月30日, 下午10:02:55
    Author     : p5p53
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            java.util.Date date= new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
        %>
        <form action="utilization.jsp" method="GET">
            Month : <input type="number" name="month" value="<%=month%>" required><br>
            Year : <input type="number" name="year" value="<%=year%>" required><br>
            <input type="radio" name="range" value="month" checked required > Month | <input type="radio" name="range" value="year"> Year<br>
            <input type="submit" value="Check">
        </form>
    </body>
</html>
