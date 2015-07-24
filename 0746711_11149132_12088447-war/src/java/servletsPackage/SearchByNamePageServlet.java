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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puser
 */
public class SearchByNamePageServlet extends HttpServlet {

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
        out.println("<title>Product ID search</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Product ID search</h1>");
        out.println("<form action=SearchByNamePageServlet method=POST>");
        out.println("<input type=text name=productName>");
        out.println("<input type=submit>");
        out.println("</form>");
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
        out.println("<title>Product Name search</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Product Name search</h1>");
                
        Product p = productBean.getByName(request.getParameter("productName"));
        
        out.println("<br>Name = <a href=ProductPageServlet>" + p.getName() + "</a> Quantity = " + p.getQuantity() + "<form action=ProductPageServlet method=GET><input type=hidden name=id value=" + Integer.toString(p.getId()) + "><input type=submit value=View></form>");
        
        out.println("<a href=ShoppingCartPageServlet>View My Cart</a>");
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
