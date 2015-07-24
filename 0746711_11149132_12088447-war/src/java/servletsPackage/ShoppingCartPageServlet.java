/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsPackage;

import beans.ShoppingCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author puser
 */
public class ShoppingCartPageServlet extends HttpServlet {

    

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
        
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {

            try {
                System.out.println("request new bean\n");
                Context c = new InitialContext();
                shoppingCart = (ShoppingCart) c.lookup("java:global/02_-_StatefulSessionBean-Cart/02_-_StatefulSessionBean-Cart-ejb/ShoppingCartBean!shoppingApp.ejb.ShoppingCart");
                session.setAttribute("cart", shoppingCart);
            } catch (NamingException ne) {
                throw new ServletException(ne);
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Shopping Cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Your cart contains the following:</h2><br>");
        out.println(shoppingCart.getItemList());
        out.println("<form action=ShoppingCartPageServlet method=POST>");
        out.println("<input type=hidden name=action value=cancel>");
        out.println("<input type=submit value=Cancel>");
        out.println("</form><br>");
        out.println("<form action=ShoppingCartPageServlet method=POST>");
        out.println("<input type=hidden name=action value=checkout>");
        out.println("<input type=submit value=Checkout>");
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
        
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {

            try {
                System.out.println("request new bean\n");
                Context c = new InitialContext();
                shoppingCart = (ShoppingCart) c.lookup("java:global/02_-_StatefulSessionBean-Cart/02_-_StatefulSessionBean-Cart-ejb/ShoppingCartBean!shoppingApp.ejb.ShoppingCart");
                session.setAttribute("cart", shoppingCart);
            } catch (NamingException ne) {
                throw new ServletException(ne);
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Shopping Cart</title>");
        out.println("</head>");
        out.println("<body>");

        String action = request.getParameter("action");
        if (action != null && action.equals("cancel")) {
            
            out.println("<h2>Order cancelled</h2>");
            shoppingCart.cancel();
            session.removeAttribute("cart");
        }
        else if (action != null && action.equals("checkout")) {
            out.println("<h2>You checked out the following:</h2>");
            out.println(shoppingCart.checkout());
            session.removeAttribute("cart");
        }
        out.println("</body>");
        out.println("</html>");
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
