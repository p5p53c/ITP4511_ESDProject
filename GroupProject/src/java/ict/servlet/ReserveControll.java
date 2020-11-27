/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.StudentBean;
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
        
        if ("list".equalsIgnoreCase(action)) {
            ArrayList equipment = db.queryEquipment();
            request.setAttribute("equipment", equipment);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Reservation.jsp");
            rd.forward(request, response);
        } else if ("reserve".equalsIgnoreCase(action)) {
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
            }
        }
    }

}
