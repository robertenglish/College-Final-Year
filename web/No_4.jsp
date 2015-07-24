<%-- 
    Document   : No_4
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A4 – Insecure Direct Object References</title>
    </head>
    <body>
        <h3>A4 – Insecure Direct Object References</h3>
        
        <br><b>General Description</b>
        <br>A direct object reference occurs when a developer exposes a reference to an internal implementation object, such as a file, directory, or database key.
        <br>Without an access control check or other protection, attackers can manipulate these references to access unauthorized data.
        <br>        
        <br><b>Typical Impact</b>
        <br>Users are able to access unauthorized files or data
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Attacker notices his account parameter is 6065   ?acct=6065
        <br>2. He modifies it to a nearby number   ?acct=6066
        <br>3. Attacker views the victim’s account information
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Eliminating the direct object reference<<</b>
        <br>Replace them with a temporary mapping value (e.g. 1, 2, 3)
        <br>ESAPI provides support for numeric & random mappings
        <br>
        <b>>>Validating the direct object reference<<</b>
        <br>Verify the parameter value is properly formatted
        <br>Verify the user is allowed to access the target object
        <br>(Query constraints work great!)
        <br>Verify the requested mode of access is allowed to the target object (e.g., read, write, delete)
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/Insecure_Direct_Object_Reference_Prevention_Cheat_Sheet
        
    </body>

</html>
