package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EquipEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      ict.bean.EquipmentBean e = null;
      synchronized (request) {
        e = (ict.bean.EquipmentBean) _jspx_page_context.getAttribute("e", PageContext.REQUEST_SCOPE);
        if (e == null){
          e = new ict.bean.EquipmentBean();
          _jspx_page_context.setAttribute("e", e, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");

            String type = e.getEquipmentID() != 0? "Edit" : "Add";
            int ID = e.getEquipmentID() != 0 ? e.getEquipmentID():0;
            String name = e.getName() != null ? e.getName():"";
            int qty = e.getQty() != 0 ? e.getQty():0;
            String status = e.getStatus() != null ? e.getStatus():"";
        
      out.write("\n");
      out.write("        ");
      out.print(type);
      out.write(" equipment\n");
      out.write("        <form method=\"get\" action=\"confirm.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"");
      out.print(type);
      out.write("\" />\n");
      out.write("            ");
 
                if ("Edit".equalsIgnoreCase(type))
                    out.println("ID <input name=\"id\" type=\"text\" value=" + ID + " readonly/><br>");
                else
                    out.println("<input name=\"id\" type=\"hidden\" value=\"0\"/>");
             
      out.write("\n");
      out.write("            Name <input name=\"name\" type=\"text\" value=\"");
      out.print(name);
      out.write("\" required/> <br>\n");
      out.write("            Quantity <input name=\"qty\" type=\"number\" value=\"");
      out.print(qty);
      out.write("\" required/> <br>\n");
      out.write("            Status <input name=\"status\" type=\"radio\" value=\"A\" id=\"Available\" required ");
 if("A".equalsIgnoreCase(status)){out.write("checked");} 
      out.write("/><label for=\"Available\"> Available</label> | \n");
      out.write("                    <input name=\"status\" type=\"radio\" value=\"N\" id=\"Nonavailable\" ");
 if("N".equalsIgnoreCase(status)){out.write("checked");} 
      out.write("/><label for=\"Nonavailable\"> Nonavailable</label><br>\n");
      out.write("                    <input type=\"submit\" value=\"submit\"/> <button value=\"back\" onclick=\"location.href'TechMain.jsp'\"></button><br>\n");
      out.write("        </form>\n");
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
