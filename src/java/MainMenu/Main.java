/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author Reiner
 */
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] titleChoice = {"A1 – Injection","A2 – Broken Authentication and Session Management", 
            "A3 – Cross-Site Scripting (XSS)","A4 – Insecure Direct Object References","A5 – Security Misconfiguration", 
            "A6 – Sensitive Data Exposure","A7 – Missing Function Level Access Control","A8 - Cross-Site Request Forgery (CSRF)",
            "A9 - Using Components with Known Vulnerabilities","A10 – Unvalidated Redirects and Forwards"};   
       
       try {
            /*
             * 1. test for param and save in local var 
             * 2. test for cookies - if present update values, else set cookies
            *  3. set html code
             */
           String title = null;
           
            // test for passed parameter
            String param = request.getParameter("title");
            if (param != null) {
                Cookie tc = new Cookie("title", param);
                tc.setMaxAge(360);
                response.addCookie(tc);
                response.sendRedirect("No_" + param + ".jsp");
            }

            // find & check cookies
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("textSize")) {
                    // if no parameter was passed (textSize == null)
                    // update local var
                    if (param == null) {
                        // update local var
                        param = cookies[i].getValue();
                    }
                }
                
                if (title == null) {
                title = "1"; // default is the first option
                }
                
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Main</title>");
            out.println("</head>");
            out.println("<font size=" + 3 + " >");
            out.println("The OWASP Top 10 are the most common methods of attacking web based applications<br>");
            out.println("(Choose any one of the ten attack methods to learn more!)<br>");
            out.println("</font><br>");

            out.println("<form action=Main method=POST>");
            out.println("<table>");
            
            for(int i=0;i<titleChoice.length;i++){
             out.println("<tr><td>" + titleChoice[i] + "</td>");
             out.println("<td><input type=radio name=title value="+(i+1));
             if (title.equals(i)) {
                out.println("checked");
             }
             out.println("</td></tr>");
            }
 
            out.println("<tr><td colspan=2><input type=submit><br><br />");            
            
            out.println("<table BORDER=1 CELLPADDING=2 CELLSPACING=3 WIDTH=150% >");
            out.println("<tr><td><b>" + "Feature" + "</b></td>" + "<td><b>" + "File" + "</b></td>" + "<td><b>" + "Line" + "</b></td></tr>");
            out.println("<tr><td>" + "doGET" + "</td>" + "<td>" + " - - - " + "</td>" + "<td>" + "- - - " + "</td></tr>");
            out.println("<tr><td>" + "doPOST" + "</td>" + "<td>" + " - - - " + "</td>" + "<td>" + " - - - " + "</td></tr>");
            out.println("<tr><td>" + "JSP Error Page" + "</td>" + "<td>" + " error.jsp " + "</td>" + "<td>" + "15" + "</td></tr>");
            out.println("<tr><td>" + "JSP Error Cause" + "</td>" + "<td>" + " No8.jsp" + "</td>" + "<td>" + "20" + "</td></tr>");
            out.println("<tr><td>" + "JSP Declaration Element" + "</td>" + "<td>" + "No2.jsp" + "</td>" + "<td>" + "23" + "</td></tr>");
            out.println("<tr><td>" + "JSP Expression Element" + "</td>" + "<td>" + "error.jsp" + "</td>" + "<td>" + "15" + "</td></tr>");            
            out.println("</table>");
            
            out.println("</table></form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
