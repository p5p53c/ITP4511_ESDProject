package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TechMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Technician Main</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("         ");
      ict.bean.TechnicianBean userInfo = null;
      synchronized (session) {
        userInfo = (ict.bean.TechnicianBean) _jspx_page_context.getAttribute("userInfo", PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new ict.bean.TechnicianBean();
          _jspx_page_context.setAttribute("userInfo", userInfo, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("        <h1>Hello, ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.TechnicianBean)_jspx_page_context.findAttribute("userInfo")).getName())));
      out.write("</h1>\r\n");
      out.write("        <p>Welcome to the IVPET Borrowing System</p>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <ol><a href=\"ListController?action=techlist\">Inventory management</a></ol>\r\n");
      out.write("            <ol><a href=\"ListController?action=techrequestlist\">Borrowing request</a></ol>\r\n");
      out.write("            <ol><a href=\"ListController?action=techreturnlist\">Return equipment</a></ol>\r\n");
      out.write("            ");

                int due = Integer.parseInt(session.getAttribute("due").toString());
                if (due > 0) {
                    out.print("<ol><a href=\"ListController?action=techduelist\"><p style=\"color:red\">" + due + " equipment haven't return</p></a></ol>");
                }
            
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("        <form method=\"post\" action=\"main\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"logout\">\r\n");
      out.write("            <input type=\"submit\" value=\"Logout\" name=\"logoutButton\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
