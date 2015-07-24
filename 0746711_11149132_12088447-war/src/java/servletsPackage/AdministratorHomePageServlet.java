/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsPackage;

import beans.ProductBean;
import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puser
 */
public class AdministratorHomePageServlet extends HttpServlet {

    

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
        out.println("<title>Administrator Homepage</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Administrator Homepage</h1>");
        out.println("<br/>");
        out.println("<a href=AddNewProductPageServlet>Add a new product to the website</a>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a href=RemoveProductPageServlet>Remove a product from the website</a>");
        out.println("<br/>");
        
        
        List<Product> list = productBean.getAll();
        
        for (Product p : list) {
            out.println("<br>Name = " + p.getName() + " Quantity = " + p.getQuantity() + "<form action=AdministratorHomePageServlet method=POST><input type=hidden name=id value=" + Integer.toString(p.getId()) + "><input type=text name=quantity><input type=submit value=+/- Product Stock Level></form>");
        }
        
        out.println("</body></html>");
        
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
        out.println("<title>Administrator Homepage</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Administrator Homepage</h1>");
        out.println("<br/>");
        out.println("<a href=AddNewProductPageServlet>Add a new product to the website</a>");
        out.println("<br/>");
        out.println("<br/>");
        out.println("<a href=RemoveProductPageServlet>Remove a product from the website</a>");
        out.println("<br/>");
        
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        productBean.changeStockLevel(id, quantity);
        
        List<Product> list = productBean.getAll();
        
        for (Product p : list) {
            out.println("<br>Name = " + p.getName() + " Quantity = " + p.getQuantity() + "<form action=AdministratorHomePageServlet method=POST><input type=hidden name=id value=" + Integer.toString(p.getId()) + "><input type=text name=quantity><input type=submit value=+/- Product Stock Level></form>");
        }
        
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
