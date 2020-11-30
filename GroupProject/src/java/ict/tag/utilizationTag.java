/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.tag;

import ict.bean.ReserveRecordBean;
import ict.db.ESDDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author p5p53
 */
public class utilizationTag extends SimpleTagSupport {
    
    private int month;
    private int year;
    private String range;
    private ESDDB db;
    
    public void doTag() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/esd";
            String dbUser = "root";
            String dbPassword = "";
            db = new ESDDB (dbUrl, dbUser, dbPassword);
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();
            if ("month".equalsIgnoreCase(range)) {
                ArrayList<ReserveRecordBean> list = db.querySelectMonth(month, year);
                out.println("Equipment utilization rate in " + month + ", " + year);
                out.println("<table border='1'>");
                out.println("<tr><th>Equipment Name</th><th>Borrow Time</th></tr>");
                for (int i = 0; i < list.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + list.get(i).getEquipname() + "</td>");
                    out.print("<td>" + list.get(i).getCount() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else if ("year".equalsIgnoreCase(range)) {
                ArrayList<ReserveRecordBean> list = db.querySelectMonth(month, year);
                out.println("Equipment utilization rate in " + year);
                out.println("<table border='1'>");
                out.println("<tr><th>Equipment Name</th><th>Borrow Time</th></tr>");
                for (int i = 0; i < list.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + list.get(i).getEquipname() + "</td>");
                    out.print("<td>" + list.get(i).getCount() + "</td>");
                    out.println("</tr>");
                }
                out.print("</table>");
            }
            out.print("<a href=\"UtilizationInput.jsp\">Back</a>");
        } catch (IOException e) {
            
        }
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRange(String range) {
        this.range = range;
    }
    
    
}
