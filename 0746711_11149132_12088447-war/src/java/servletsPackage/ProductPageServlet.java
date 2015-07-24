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
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author puser
 */
public class ProductPageServlet extends HttpServlet {

    ProductBean productBean;
    CommentBean commentBean;
    Product p = new Product();
    
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
        out.println("<title>Product Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Product Page</h1>");
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        p = productBean.getProduct(id);
        
        out.println("<br>" + p.getName() + "Quantity: " + p.getQuantity());
        out.println("<br>");
        out.println("<form action=ProductPageServlet method=POST>");
        out.println("<input type=hidden name=action value=adjust>");
        out.println("<input type=text name=quantity>");
        out.println("<input type=submit value=+/- Cart>");
        out.println("</form>");
        out.println("<form action=ProductPageServlet method=POST>");
        out.println("<input type=hidden name=action value=viewComments>");
        out.println("<input type=submit value=View Product Reviews");
        out.println("</form>");
        out.println("<form action=ProductPageServlet method=POST>");
        out.println("<input type=hidden name=action value=addComment>");
        out.println("<input type=text name=comment>");
        out.println("<input type=submit value=View Product Reviews");
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
        if (action != null && action.equals("adjust")) {
            
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            if(quantity <= p.getQuantity())
            {
                productBean.changeStockLevel(p.getId(), (quantity *- 1));
                shoppingCart.addItem(Integer.toString(p.getId()), quantity);

                out.println("<h2>The following items were added</h2>");
                out.println("<br>" + p.getName() + ": " + quantity);
            }
            else
            {
                out.println("<h2>Your cart does not contain that many items</h2>");
            }
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
            
        }
        else if (action != null && action.equals("viewComments")) {
            
            List<Comment> comments = commentBean.getAll(p.getId());
            int i=0;
            for (Comment comment : comments) {
                out.println("<br>Review #" + i + "<br>" + comment.getComment() + "<br>");
                i++;
            }
        }
        else if (action != null && action.equals("addComment")) {
            
            String comment = request.getParameter("comment");
            commentBean.createNewComment(p.getId(), comment);
            
            out.println("Your comment was added");
        }
        
        out.println("<a href=ProductPageServlet>Return to product page</a>");
        out.println("<a href=ShoppingCartPageServlet>View My Cart</a>");
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
