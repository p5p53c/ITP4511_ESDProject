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
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController extends HttpServlet {
    private ESDDB db;

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
        String identity = request.getParameter("identity");
        String action = request.getParameter("action");
        if (!isAuthenticated(request) && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }
    
    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int username = Integer.parseInt(request.getParameter("ID"));
        String password = request.getParameter("pwd");
        String targetURL = "";
        String identity = request.getParameter("identity");
        boolean isValid = false;
        if ("student".equalsIgnoreCase(identity)) {
            isValid = db.isValidStud(username, password);
            if(isValid) {
                HttpSession session = request.getSession(true);
                StudentBean bean = new StudentBean();
                bean.setStudID(username);
                bean.setPwd(password);
                session.setAttribute("userInfo", bean);
                targetURL = "/StudentMain.jsp";
            } else {
                targetURL = "/loginError.jsp";
            }
        } else if ("Tech".equalsIgnoreCase(identity)) {
            isValid = db.isValidTech(username, password);
            if(isValid) {
                HttpSession session = request.getSession(true);
                TechnicianBean bean = new TechnicianBean();
                bean.setTechID(username);
                bean.setPwd(password);
                session.setAttribute("userInfo", bean);
                targetURL = "/TechMain.jsp";
            } else {
                targetURL = "/loginError.jsp";
            }
        } else if ("STech".equalsIgnoreCase(identity)) {
            isValid = db.isValidSenior(username, password);
            if(isValid) {
                HttpSession session = request.getSession(true);
                SeniorBean bean = new SeniorBean();
                bean.setSeniorID(username);
                bean.setPwd(password);
                session.setAttribute("userInfo", bean);
                targetURL = "/SeniorMain.jsp";
            } else {
                targetURL = "/loginError.jsp";
            }
        } else {
            
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo") != null) {
            result = true;
        }
        return result;
    }
    
    private void doLogin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetURL = "index.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        doLogin(request, response);
    }

    @Override
    public void init() throws ServletException {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new ESDDB (dbUrl, dbUser, dbPassword);
    }

}
