package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ict.bean.EquipmentBean;

public final class EquipManage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Equipment List</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      java.util.ArrayList<ict.bean.EquipmentBean> equipment = null;
      synchronized (request) {
        equipment = (java.util.ArrayList<ict.bean.EquipmentBean>) _jspx_page_context.getAttribute("equipment", PageContext.REQUEST_SCOPE);
        if (equipment == null){
          try {
            equipment = (java.util.ArrayList<ict.bean.EquipmentBean>) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "java.util.ArrayList<ict.bean.EquipmentBean>");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "java.util.ArrayList<ict.bean.EquipmentBean>", exc);
          }
          _jspx_page_context.setAttribute("equipment", equipment, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <table border = \"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Equipment Name</th>\n");
      out.write("                <th>Total Number</th>\n");
      out.write("                <th>Available Number</th>\n");
      out.write("                <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("                ");

                    for (int i = 0; i < equipment.size(); i++) {
                        EquipmentBean e = equipment.get(i);
                        out.println("<tr>");
                        out.println("<td>" + e.getName() + "</td>");
                        out.println("<td>" + e.getQty() + "</td>");
                        out.println("<td>" + e.getAvaqty() + "</td>");
                        out.println("<td><a href=\"ListController?action=editEquip&id=" + e.getEquipmentID() + "\">edit</a> | ");
                        out.println("<a href=\"EquipController?action=delete&confirm=false&id=" + e.getEquipmentID() + "\">delete</a></td>");
                        out.println("</tr>");
                    }
                
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <a href=\"EquipEdit.jsp\">Create Equipment</a>\n");
      out.write("        <a href=\"TechMain.jsp\">Back</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
