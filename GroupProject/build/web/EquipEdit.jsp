<%-- 
    Document   : EquipEdit
    Created on : 2020年11月27日, 下午08:50:17
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
        <jsp:useBean id="e" scope="request" class="ict.bean.EquipmentBean" />
        <%
            String type = e.getEquipmentID() != 0? "Edit" : "Add";
            int ID = e.getEquipmentID() != 0 ? e.getEquipmentID():0;
            String name = e.getName() != null ? e.getName():"";
            int qty = e.getQty() != 0 ? e.getQty():0;
            String status = e.getStatus() != null ? e.getStatus():"";
        %>
        <%=type%> equipment
        <form method="get" action="confirm.jsp">
            <input type="hidden" name="action" value="<%=type%>" />
            <% 
                if ("Edit".equalsIgnoreCase(type))
                    out.println("ID <input name=\"id\" type=\"text\" value=" + ID + " readonly/><br>");
                else
                    out.println("<input name=\"id\" type=\"hidden\" value=\"0\"/>");
             %>
            Name <input name="name" type="text" value="<%=name%>" required/> <br>
            Quantity <input name="qty" type="number" value="<%=qty%>" required/> <br>
            Status <input name="status" type="radio" value="A" id="Available" required <% if("A".equalsIgnoreCase(status)){out.write("checked");} %>/><label for="Available"> Available</label> | 
                    <input name="status" type="radio" value="N" id="Nonavailable" <% if("N".equalsIgnoreCase(status)){out.write("checked");} %>/><label for="Nonavailable"> Nonavailable</label><br>
            <input type="submit" value="submit"/> <br>
        </form>
    </body>
</html>
