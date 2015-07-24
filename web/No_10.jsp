<%-- 
    Document   : No_10
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A10 – Unvalidated Redirects and Forwards</title>
    </head>
    <body>
        <h3>A10 – Unvalidated Redirects and Forwards</h3>
        
        <br><b>General Description</b>
        <br>Web applications frequently redirect and forward users to other pages and websites, and use untrusted data to determine the destination pages. Without
        <br>proper validation, attackers can redirect victims to phishing or malware sites, or use forwards to access unauthorized pages.
        <br>
        <br><b>Typical Impact</b>
        <br>Redirect victim to phishing or malware site
        <br>Attacker’s request is forwarded past security checks, allowing unauthorized function or data access
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker sends attack to victim via email or webpage
        <br>2. Victim clicks link containing unvalidated parameter
        <br>3. Application redirects victim to attacker’s site
        <br>4. Evil site installs malware on victim, or phish’s for private information
        <br>
        <br><b>Avoided by...</b>
        <br>Avoid using redirects and forwards as much as you can
        <br>If used, don’t involve user parameters in defining the target URL
        <br>If you ‘must’ involve user parameters, then either
        <br>>>Validate each parameter to ensure its valid and authorized for the current user, or
        <br>>>(preferred) – Use server side mapping to translate choice provided to user with actual target page
        <br>Defense in depth: For redirects, validate the target URL after it is calculated to make sure it goes to an authorized external site
        <br>ESAPI can do this for you!!
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>http://owasp-esapi-java.googlecode.com/svn/trunk_doc/org/owasp/esapi/filters/SecurityWrapperResponse.html#sendRedirect(java.lang.String) 

    </body>

</html>
