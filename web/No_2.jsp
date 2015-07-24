<%-- 
    Document   : No
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A2 – Broken Authentication and Session Management</title>
    </head>
    <body>
        <h3>A2 – Broken Authentication and Session Management</h3>
        
        <br><b>General Description</b>
        <br>Application functions related to authentication and session management are often not implemented correctly, allowing attackers to compromise passwords,
        <br>keys, or session tokens, or to exploit other implementation flaws to assume other users’ identities.
        <br>

        <%!
            String theImpact = new String("Typical Impact");
            {
                System.out.println( theImpact );   
            }
        %>
        <br>User accounts compromised or user sessions hijacked
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. User sends credentials
        <br>2. Site uses URL rewriting (i.e., put session in URL)
        <br>3. User clicks on a link to http://www.hacker.com in a forum
        <br>4. Hacker checks referrer logs on www.hacker.com and finds user’s JSESSIONID
        <br>5. Hacker uses JSESSIONID and takes over victim’s account
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Verifying your architecture<<</b>
        <br>Authentication should be simple, centralized, and standardized. 
	<br>Use the standard session id provided by your container.
        <br>Be sure SSL protects both credentials and session id at all times.
        <br>
        <b>>>Verifying your implementation<<</b>
        <br>Forget automated analysis approaches.
        <br>Check your SSL certificate.
        <br>Examine all the authentication-related functions.
        <br>Verify that logoff actually destroys the session.
        <br>Use OWASP’s WebScarab to test the implementation.
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/Authentication_Cheat_Sheet 

    </body>

</html>
