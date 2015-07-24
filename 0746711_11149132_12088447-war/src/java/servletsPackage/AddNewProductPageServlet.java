/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import beans.*;

/**
 *
 * @author puser
 */
public class AddNewProductPageServlet extends HttpServlet {

    
    ProductBean productBean;
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add New Product Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Add New Product Page</h1>");
        out.println("<br/>");
        out.println("<form action=AddNewProductPageServlet method=POST>");
        out.println("<input type=text name=productName>");
        out.println("<input type=submit value=Create>");
        out.println("</form>");
        
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add New Product Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Add New Product Page</h1>");
        out.println("<br/>");
        
        String name = request.getParameter("productName");
        int productId = productBean.createNewProduct(name, 0.0);
        
        out.println("Created " + name + " with product ID: " + productId);
        out.println("<a href=AdministratorHomePageServlet>Return to Homepage</a>");
        
        out.println("</body></html>");
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
