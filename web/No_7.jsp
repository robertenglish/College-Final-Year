<%-- 
    Document   : No_7
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A7 – Missing Function Level Access Control</title>
    </head>
    <body>
        <h3>A7 – Missing Function Level Access Control</h3>
        
        <br><b>General Description</b>
        <br>Most web applications verify function level access rights before making that functionality visible in the UI. However, applications need to perform the same
        <br>access control checks on the server when each function is accessed. If requests are not verified, attackers will be able to forge requests in order to
        <br>access functionality without proper authorization.
        <br>
        <br><b>Typical Impact</b>
        <br>Attackers invoke functions and services they’re not authorized for
        <br>Access other user’s accounts and data
        <br>Attackers extract secrets to use in additional attacks
        <br>Perform privileged actions
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker notices the URL indicates his role    /user/getAccounts
        <br>2. He modifies it to another directory (role)    /admin/getAccounts, or    /manager/getAccounts
        <br>3. Attacker views more accounts than just their own
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>For function, a site needs to do 3 things<<</b>
        <br>Restrict access to authenticated users (if not public)
        <br>Enforce any user or role based permissions (if private)
        <br>Completely disallow requests to unauthorized page types (e.g., config files, log files, source files, etc.)
        <br>
        <br><b>>>Verify your architecture<<</b>
        <br>Use a simple, positive model at every layer
        <br>Be sure you actually have a mechanism at every layer
        <br>
        <br><b>>>Verify the implementation<<</b> 
        <br>Forget automated analysis approaches
        <br>Verify that each URL (plus any parameters) referencing a function is protected by
        <br>>>An external filter, like Java EE web.xml or a commercial product
        <br>>>Or internal checks in YOUR code – e.g., use ESAPI’s isAuthorizedForURL() method
        <br>Verify the server configuration disallows requests to unauthorized file types
        <br>Use OWASP’s ZAP or your browser to forge unauthorized requests
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/Access_Control_Cheat_Sheet
    </body>

</html>
