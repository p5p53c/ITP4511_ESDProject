/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.*;
import ict.db.ESDDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p5p53
 */
@WebServlet(name = "ReserveControll", urlPatterns = {"/ReserveControll"})
public class ReserveControll extends HttpServlet {

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
        String action = request.getParameter("action");
        
        if ("reserve".equalsIgnoreCase(action)) {
            int equipID = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession(false);
            StudentBean stud = (StudentBean) session.getAttribute("userInfo");
            int studID = stud.getStudID();
            
            boolean isVaild = db.addBorrowrecord(equipID, studID);
            if (isVaild) {
                int borrowID = db.getBorrowID(studID);
                PrintWriter out = response.getWriter();
                out.write("<html><body>");
                out.write("Your reserv number is " + borrowID);
                out.write("<br><a href=\"StudentMain.jsp\">Back</a>");
            }
        } else if ("reserverecord".equalsIgnoreCase(action)) {
            HttpSession session = request.getSession(false);
            StudentBean stud = (StudentBean) session.getAttribute("userInfo");
            int studID = stud.getStudID();
            ArrayList reserverecord = db.queryStudRecord(studID);
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/reserverecord.jsp");
            rd.forward(request, response);
        } else if ("A".equalsIgnoreCase(action)) {
            int borrowID = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession(false);
            TechnicianBean tech = (TechnicianBean) session.getAttribute("userInfo");
            int techID = tech.getTechID();
            try {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String borrowdate = formatter.format(date);
                Calendar c = Calendar.getInstance();
                c.setTime(formatter.parse(borrowdate));
                c.add(Calendar.DATE, 14);
                String returndate = formatter.format(c.getTime());
                db.borrowrequest(borrowID, techID, borrowdate, returndate);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ListController?action=techrequestlist");
                rd.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ReserveControll.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("R".equalsIgnoreCase(action)) {
            int borrowID = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession(false);
            TechnicianBean tech = (TechnicianBean) session.getAttribute("userInfo");
            int techID = tech.getTechID();
            db.borrowrequest(borrowID, techID);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ListController?action=techrequestlist");
            rd.forward(request, response);
        } else if ("return".equalsIgnoreCase(action)) {
            int borrowID = Integer.parseInt(request.getParameter("id"));
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String returndate = formatter.format(date);
            db.techReturnEquip(borrowID, returndate);
            ArrayList reserverecord = db.queryReturnList();
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ReturnList.jsp");
            rd.forward(request, response);
        }
    } 

}
