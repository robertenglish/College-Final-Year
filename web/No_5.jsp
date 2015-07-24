<%-- 
    Document   : No_5
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A5 – Security Misconfiguration</title>
    </head>
    <body>
        <h3>A5 – Security Misconfiguration</h3>
        
        <br><b>General Description</b>
        <br>Good security requires having a secure configuration defined and deployed for the application, frameworks, application server, web server, database server,
        <br>and platform. Secure settings should be defined, implemented, and maintained, as defaults are often insecure. Additionally, software should be kept up to date.
        <br>
        <br><b>Typical Impact</b>
        <br>Install "backdoor" through missing OS or server patch
        <br>Unauthorized access to default accounts, application functionality or data, or unused but accessible functionality due to poor server configuration
        <br>
        <br><b>Different Attack Types</b>
        <br>1. Hidden manipulation
        <br>2. Parameter tampering
        <br>3. Cookie poisoning
        <br>4. Stealth commanding
        <br>5. Forced browsing
        <br>6. Backdoor and debug options
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Verifying your system’s configuration management<<</b>
        <br>Secure configuration “hardening” guideline
        <br>(Automation is REALLY USEFUL here)
        <br>Must cover entire platform and application
        <br>Analyze security effects of changes
        <br>
        <br><b>>>Testing if you can you “dump” the application configuration<<</b>
        <br>Build reporting into your process
        <br>If you can’t verify it, it isn’t secure
        <br>
        <br><b>>>Verifying the implementation<<</b> 
        <br>Scanning finds generic configuration and missing patch problems
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/Top_10_2013-A5_Security_Misconfiguration
    
    </body>

</html>
