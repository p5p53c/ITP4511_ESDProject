/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.EquipmentBean;
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
@WebServlet(name = "EquipController", urlPatterns = {"/EquipController"})
public class EquipController extends HttpServlet {
    
    private ESDDB db;

    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new ESDDB (dbUrl, dbUser, dbPassword);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        
        
        if ("Add".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            int qty = Integer.parseInt(request.getParameter("qty"));
            String status = request.getParameter("status");
            db.addEquipmentRecord(name, qty, status);
            ArrayList equipment = db.queryTechEquipment();
            request.setAttribute("equipment", equipment);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EquipManage.jsp");
            rd.forward(request, response);
        } else if ("Edit".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            int qty = Integer.parseInt(request.getParameter("qty"));
            String status = request.getParameter("status");
            EquipmentBean eb = new EquipmentBean();
            eb.setEquipmentID(id);
            eb.setName(name);
            eb.setQty(qty);
            eb.setStatus(status);
            db.editEquip(eb);
            ArrayList equipment = db.queryTechEquipment();
            request.setAttribute("equipment", equipment);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EquipManage.jsp");
            rd.forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            boolean confirm = Boolean.parseBoolean(request.getParameter("confirm"));
            if (confirm == true) {
                db.delEquip(id);
                ArrayList equipment = db.queryTechEquipment();
                request.setAttribute("equipment", equipment);
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/EquipManage.jsp");
                rd.forward(request, response);
            } else {
                EquipmentBean eb = db.queryEquipmentByID(id);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirm.jsp?action=delete&id=" + id + "&name=" + eb.getName() + "&qty=" + eb.getQty()+ "&status=" + eb.getStatus());
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
