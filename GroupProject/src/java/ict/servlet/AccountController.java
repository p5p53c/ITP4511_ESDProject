/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.EquipmentBean;
import ict.bean.StudentBean;
import ict.bean.TechnicianBean;
import ict.db.ESDDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p5p53
 */
@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {
    
    private ESDDB db;
    
    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new ESDDB (dbUrl, dbUser, dbPassword);
    }
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("Create".equalsIgnoreCase(action)) {
            String role = request.getParameter("role");
            if ("Student".equalsIgnoreCase(role)) {
                StudentBean sb = new StudentBean();
                sb.setName(request.getParameter("name"));
                sb.setPwd(request.getParameter("pwd"));
                boolean isVaild = db.addStudAC(sb);
                
                if (isVaild) {
                    int studID = db.getStudID();
                    PrintWriter out = response.getWriter();
                    out.write("<html><body>");
                    out.write(request.getParameter("name") + " student ID is " + studID);
                    out.write("<br><a href=\"AccountEdit.jsp\">Back</a>");
                } else {
                    PrintWriter out = response.getWriter();
                    out.write("<html><body>");
                    out.write("Cannot create account");
                    out.write("<br><a href=\"AccountEdit.jsp\">Back</a>");
                }
            } else if ("Tech".equalsIgnoreCase(role)) {
                TechnicianBean tb = new TechnicianBean();
                tb.setName(request.getParameter("name"));
                tb.setPwd(request.getParameter("pwd"));
                boolean isVaild = db.addTechAC(tb);
                
                if (isVaild) {
                    int techID = db.getTechID();
                    PrintWriter out = response.getWriter();
                    out.write("<html><body>");
                    out.write(request.getParameter("name") + " Technician ID is " + techID);
                    out.write("<br><a href=\"AccountEdit.jsp\">Back</a>");
                } else {
                    PrintWriter out = response.getWriter();
                    out.write("<html><body>");
                    out.write("Cannot create account");
                    out.write("<br><a href=\"AccountEdit.jsp\">Back</a>");
                }
            }
        } else if ("Edit".equalsIgnoreCase(action)) {
            String role = request.getParameter("role");
            if ("Student".equalsIgnoreCase(role)) {
                StudentBean sb = new StudentBean();
                sb.setStudID(Integer.parseInt(request.getParameter("id")));
                sb.setName(request.getParameter("name"));
                sb.setPwd(request.getParameter("pwd"));
                db.editStud(sb);
                ArrayList stud = db.queryStud();
                request.setAttribute("memberlist", stud);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/StudAccountList.jsp");
                rd.forward(request, response);
            } else if ("Tech".equalsIgnoreCase(role)) {
                TechnicianBean tb = new TechnicianBean();
                tb.setTechID(Integer.parseInt(request.getParameter("id")));
                tb.setName(request.getParameter("name"));
                tb.setPwd(request.getParameter("pwd"));
                db.editTech(tb);
                ArrayList tech = db.queryTech();
                request.setAttribute("memberlist", tech);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/TechAccountList.jsp");
                rd.forward(request, response);
            }
        }
    }

}
