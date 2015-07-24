<%-- 
    Document   : No_3
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A3 – Cross-Site Scripting (XSS)</title>
    </head>
    <body>
        <h3>A3 – Cross-Site Scripting (XSS)</h3>
        
        <br><b>General Description</b>
        <br>XSS flaws occur whenever an application takes untrusted data and sends it to a web browser without proper validation or escaping. XSS allows attackers to
        <br> execute scripts in the victim’s browser which can hijack user sessions, deface web sites, or redirect the user to malicious sites.
        <br>
        <br><b>Typical Impact</b>
        <br>Steal user’s session, steal sensitive data, rewrite web page, redirect user to phishing or malware site
        <br>Most Severe: Install XSS proxy which allows attacker to observe and direct all user’s behavior on vulnerable site and force user to other sites
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker sets the trap – update my profile
        <br>2. Victim views page – sees attacker profile
        <br>3. Script silently sends attacker Victim’s session cookie
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Eliminating the Flaw<<</b>
        <br>Don’t include user supplied input in the output page
        <br>
        <b>>>Defending Against the Flaw<<</b>
        <br>Primary Recommendation: Output encode all user supplied input (Use OWASP’s ESAPI or Java Encoders to output encode)
        <br>Perform ‘white list’ input validation on all user input to be included in page
        <br>For large chunks of user supplied HTML, use OWASP’s AntiSamy to sanitize this HTML to make it safe
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/ESAPI
        <br>https://www.owasp.org/index.php/OWASP_Java_Encoder_Project
        <br>https://www.owasp.org/index.php/AntiSamy
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/XSS_(Cross Site Scripting) Prevention Cheat Sheet 
    
    </body>

</html>
