<%-- 
    Document   : No_6
    Created on : 12-Mar-2015, 20:07:02
    Author     : Robert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A6 – Sensitive Data Exposure</title>
    </head>
    <body>
        <h3>A6 – Sensitive Data Exposure</h3>
        
        <br><b>General Description</b>
        <br>Many web applications do not properly protect sensitive data, such as credit cards, tax IDs, and authentication credentials. Attackers may steal or modify
        <br>such weakly protected data to conduct credit card fraud, identity theft, or other crimes. Sensitive data deserves extra protection such as encryption at rest or
        <br>in transit, as well as special precautions when exchanged with the browser.
        <br>
        <br><b>Typical Impact</b>
        <br>Attackers access or modify confidential or private information
        <br>>>e.g, credit cards, health care records, financial data (yours or your customers)
        <br>Attackers extract secrets to use in additional attacks
        <br>Company embarrassment, customer dissatisfaction, and loss of trust
        <br>Expense of cleaning up the incident, such as forensics, sending apology letters, reissuing thousands of credit cards, providing identity theft insurance
        <br>Business gets sued and/or fined
        <br>
        <br><b>Typical Attack Scenario</b>
        <br>1. Victim enters credit card number in form
        <br>2. Error handler logs CC details because merchant gateway is unavailable
        <br>3. Logs are accessible to all members of IT staff for debugging purposes
        <br>4. Malicious insider steals 4 million credit card numbers
        <br>
        <br><b>Avoided by...</b>
        <br><b>>>Verifying your architecture<<</b>
        <br>Identify all sensitive data
        <br>Identify all the places that data is stored
        <br>Ensure threat model accounts for possible attacks
        <br>Use encryption to counter the threats, don’t just ‘encrypt’ the data
        <br>
        <br><b>>>Protecting with appropriate mechanisms<<</b>
        <br>File encryption, database encryption, data element encryption
        <br>
        <br><b>>>Using the mechanisms correctly<<</b> 
        <br>Use standard strong algorithms
        <br>Generate, distribute, and protect keys properly
        <br>Be prepared for key change
        <br>
        <br>>>Verify the implementation<<
        <br>A standard strong algorithm is used, and it’s the proper algorithm for this situation
        <br>All keys, certificates, and passwords are properly stored and protected
        <br>Safe key distribution and an effective plan for key change are in place 
        <br>Analyze encryption code for common flaws
        <br>
        <br><b>References</b>
        <br>https://www.owasp.org/index.php/Top_10_2013-Top_10
        <br>https://www.owasp.org/index.php/Cryptographic_Storage_Cheat_Sheet
    </body>

</html>
