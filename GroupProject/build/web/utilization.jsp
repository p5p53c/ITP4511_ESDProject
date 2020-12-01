<%-- 
    Document   : utilization
    Created on : 2020年11月30日, 下午10:35:51
    Author     : p5p53
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="SeniorNavigation.jsp" />
        <%@taglib uri="/WEB-INF/tlds/utilization.tld" prefix="ict" %>
        <% 
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            String range = request.getParameter("range");
        %>
        
        <ict:utilization month="<%=month%>"
                         year="<%=year%>"
                                          range="<%=range%>" />
    </body>
</html>
