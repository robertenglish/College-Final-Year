<%-- 
    Document   : No_1
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>#
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A1 – Injection</title>
    </head>
    <body>
        <h3>A1 - Injection</h3>
        
        <br><b>General Description</b>
        <br>Injection flaws, such as SQL, OS, and LDAP injection occur when untrusted data is sent to an interpreter as part of a command or query.
        <br> The attacker’s hostile data can trick the interpreter into executing unintended commands or accessing data without proper authorization.
        <br>
        <br><b>Typical Impact</b>
        <br>Usually severe. Entire database can usually be read or modified
        <br>May also allow full database schema, or account access, or even OS level access
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Application presents a form to the attacker
        <br>2. Attacker sends an attack in the form data
        <br>3. Application forwards attack to the database in a SQL query
        <br>4. Database runs query containing attack and sends encrypted results back to application
        <br>5. Application decrypts data as normal and sends results to the user
        <br>
        <br><b>Avoided by...</b>
        <br>Avoid the interpreter entirely, or
        <br>Use an interface that supports bind variables (e.g., prepared statements, or stored procedures),
	<br>Bind variables allow the interpreter to distinguish between code and data
        <br>Encode all user input before passing it to the interpreter
        <br>Always perform ‘white list’ input validation on all user supplied input
        <br>Always minimize database privileges to reduce the impact of a flaw
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/SQL_Injection_Prevention_Cheat_Sheet 

    </body>

</html>
