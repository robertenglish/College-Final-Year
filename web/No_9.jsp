<%-- 
    Document   : No_9
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A9 - Using Components with Known Vulnerabilities</title>
    </head>
    <body>        
        <h3>A9 - Using Components with Known Vulnerabilities</h3>
        
        <br><b>General Description</b>
        <br>Components, such as libraries, frameworks, and other software modules, almost always run with full privileges. If a vulnerable component is exploited,
        <br>such an attack can facilitate serious data loss or server takeover. Applications using components with known vulnerabilities may undermine application
        <br>defenses and enable a range of possible attacks and impacts.
        <br>
        <br><b>Typical Impact</b>
        <br>Full range of weaknesses is possible, including injection, broken access control, XSS ...
        <br>The impact could range from minimal to complete host takeover and data compromise
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker sets the trap on some website on the internet(or simply via an e-mail)
        <br>2. While logged into vulnerable site,victim views attacker site
        <br>3. Vulnerable site sees legitimate request from victim and performs the action requested
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Ideal<<</b>
        <br>Automation checks periodically (e.g., nightly build) to see if your libraries are out of date
        <br>Even better, automation also tells you about known vulnerabilities
        <br>
        <br><b>>>Minimum<<</b>
        <br>By hand, periodically check to see if your libraries are out of date and upgrade those that are
        <br>If any are out of date, but you really don’t want to upgrade, check to see if there are any known security issues with these out of data libraries
        <br>If so, upgrade those
        <br>
        <br><b>>>Could also<<</b> 
        <br>By hand, periodically check to see if any of your libraries have any known vulnerabilities at this time
        <br>>>Check CVE, other vuln repositories
        <br>>>If any do, update at least these
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10

    </body>

</html>
