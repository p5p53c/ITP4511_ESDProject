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
@WebServlet(name = "ListController", urlPatterns = {"/ListController"})
public class ListController extends HttpServlet {
    
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
        
        if ("studlist".equalsIgnoreCase(action)) {
            ArrayList equipment = db.querystudEquipment();
            request.setAttribute("equipment", equipment);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Reservation.jsp");
            rd.forward(request, response);
        } else if ("techlist".equalsIgnoreCase(action)) {
            ArrayList equipment = db.queryTechEquipment();
            request.setAttribute("equipment", equipment);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EquipManage.jsp");
            rd.forward(request, response);
        } else if ("editEquip".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id != 0) {
                EquipmentBean equipement = db.queryEquipmentByID(id);
                request.setAttribute("e", equipement);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/EquipEdit.jsp");
                rd.forward(request, response);
            }
        } else if ("techrequestlist".equalsIgnoreCase(action)) {
            ArrayList reserverecord = db.queryTechRecord();
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/BorrowRequest.jsp");
            rd.forward(request, response);
        } else if ("techduelist".equalsIgnoreCase(action)) {
            ArrayList reserverecord = db.queryTechDue();
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/DueList.jsp");
            rd.forward(request, response);
        } else if ("techborrowlist".equalsIgnoreCase(action)) {
            ArrayList reserverecord = db.queryborrow();
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/BorrowRecord.jsp");
            rd.forward(request, response);
        } else if ("stud".equalsIgnoreCase(action)) {
            ArrayList stud = db.queryStud();
            request.setAttribute("memberlist", stud);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/StudAccountList.jsp");
            rd.forward(request, response);
        } else if ("tech".equalsIgnoreCase(action)) {
            ArrayList tech = db.queryTech();
            request.setAttribute("memberlist", tech);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/TechAccountList.jsp");
            rd.forward(request, response);
        } else if ("editStud".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id != 0) {
                StudentBean student = db.queryStudByID(id);
                request.setAttribute("s", student);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/AccountEdit.jsp");
                rd.forward(request, response);
            }
        } else if ("editTech".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id != 0) {
                StudentBean student = db.queryTechByIDreturnStudent(id);
                request.setAttribute("s", student);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/AccountEdit.jsp");
                rd.forward(request, response);
            }
        } else if ("techreturnlist".equalsIgnoreCase(action)) {
            ArrayList reserverecord = db.queryReturnList();
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/ReturnList.jsp");
            rd.forward(request, response);
        } else if ("listStudRecord".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList reserverecord = db.queryStudRecord(id);
            request.setAttribute("reserverecord", reserverecord);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/reserverecord.jsp");
            rd.forward(request, response);
        }
    }
}
