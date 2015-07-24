<%-- 
    Document   : No_8
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A8 - Cross-Site Request Forgery (CSRF)</title>
    </head>
    <body> 
        <%
            int theInt = 9;
            {
                int errorInt = theInt/0;  
                
            }
        %>
        <h3>A8 - Cross-Site Request Forgery (CSRF)</h3>
        
        <br><b>General Description</b>
        <br>A CSRF attack forces a logged-on victim’s browser to send a forged HTTP request, including the victim’s session cookie and any other automatically
        <br>included authentication information, to a vulnerable web application. This allows the attacker to force the victim’s browser to generate requests the
        <br>vulnerable application thinks are legitimate requests from the victim.
        <br>
        <br><b>Typical Impact</b>
        <br>A successful CSRF attack can compromise end-user data and their associated functions
        <br>If the targeted end user is an administrator account, a CSRF attack can compromise the entire Web application
        <br>Attackers extract secrets to use in additional attacks
        <br>Perform privileged actions
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker sets the trap on some website on the internet(or simply via an e-mail)
        <br>2. While logged into vulnerable site,victim views attacker site
        <br>3. Vulnerable site sees legitimate request from victim and performs the action requested
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Add a secret, not automatically submitted, token to ALL sensitive request<<</b>
        <br>This makes it impossible for the attacker to spoof the request
        <br>(unless there’s an XSS hole in your application)
        <br>Tokens should be cryptographically strong or random
        <br>
        <br><b>>>Options<<</b>
        <br>Store a single token in the session and add it to all forms and links
        <br>Beware exposing the token in a referer header
        <br>>>Hidden fields are recommended
        <br>Can have a unique token for each function
        <br>>>Use a hash of function name, session id, and a secret
        <br>Can require secondary authentication for sensitive functions (e.g., eTrade)
        <br>
        <br><b>>>Not allowing attackers to store attacks on your site<<</b> 
        <br>Properly encode all input on the way out
        <br>This renders all links/requests inert in most interpreters
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>www.owasp.org/index.php/CSRF_Prevention_Cheat_Sheet 
    </body>
    
</html>
