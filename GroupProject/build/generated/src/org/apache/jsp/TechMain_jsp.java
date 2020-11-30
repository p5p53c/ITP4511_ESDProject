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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Technician Main</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      ict.bean.TechnicianBean userInfo = null;
      synchronized (session) {
        userInfo = (ict.bean.TechnicianBean) _jspx_page_context.getAttribute("userInfo", PageContext.SESSION_SCOPE);
        if (userInfo == null){
          userInfo = new ict.bean.TechnicianBean();
          _jspx_page_context.setAttribute("userInfo", userInfo, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <h1>Hello, ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((ict.bean.TechnicianBean)_jspx_page_context.findAttribute("userInfo")).getName())));
      out.write("</h1>\n");
      out.write("        <p>Welcome to the IVPET Borrowing System</p>\n");
      out.write("        <ul>\n");
      out.write("            <ol><a href=\"ListController?action=techlist\">Inventory management</a></ol>\n");
      out.write("            <ol><a href=\"ListController?action=techrequestlist\">Borrowing request</a></ol>\n");
      out.write("            <ol>Handle check-in/out of equipment</ol>\n");
      out.write("            ");

                int due = Integer.parseInt(session.getAttribute("due").toString());
                if (due > 0) {
                    out.print("<ol><a href=\"ListController?action=techduelist\"><p style=\"color:red\">" + due + " equipment haven't return</p></a></ol>");
                }
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <form method=\"post\" action=\"main\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"logout\">\n");
      out.write("            <input type=\"submit\" value=\"Logout\" name=\"logoutButton\">\n");
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
