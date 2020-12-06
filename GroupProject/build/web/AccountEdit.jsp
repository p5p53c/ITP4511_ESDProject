<%-- 
    Document   : AccountEdit
    Created on : 2020年11月28日, 下午11:32:13
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
        <jsp:useBean id="s" scope="request" class="ict.bean.StudentBean" />
        <%
            String type = s.getStudID()!= 0? "Edit" : "Create";
            int ID = s.getStudID() != 0 ? s.getStudID():0;
            String name = s.getName() != null ? s.getName():"";
            String pwd = s.getPwd()!= null ? s.getPwd():"";
            String back = "";
            if ("Edit".equalsIgnoreCase(type)) {
                back = "<input type=\"button\" value=\"Back\" onclick=\"javascript:window.history.back()\">";
            } else if ("Create".equalsIgnoreCase(type)) {
                back = "<input type=\"button\" value=\"Back\" onclick=\"location.href='AccountManage.jsp'\">";
            }
        %>
        <%=type%> account
        <form method="post" action="AccountConfirm.jsp">
            <input type="hidden" name="action" value="<%=type%>" />
            <% 
                if ("Edit".equalsIgnoreCase(type))
                    out.println("ID <input name=\"id\" type=\"text\" value=" + ID + " readonly/><br>");
                else
                    out.println("<input name=\"id\" type=\"hidden\" value=\"0\"/>");
             %>
            Name <input name="name" type="text" value="<%=name%>" required/> <br>
            Password <input name="pwd" type="password" value="<%=pwd%>" required/> <br>
            Role <input type="radio" name="role" value="Student" id="student" required <% if(Integer.toString(ID).charAt(0) == '1'){out.write("checked");} %>/><label for="student"> Student</label> | 
            <input type="radio" name="role" value="Tech" id="Tech" required <% if(Integer.toString(ID).charAt(0) == '2'){out.write("checked");} %> /> <label for="Tech">Technician</label><br>
            <input type="submit" value="<%=type%>"/> <%=back%><br>
        </form>
    </body>
</html>
