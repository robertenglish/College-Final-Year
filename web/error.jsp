<%-- 
    Document   : errorPage
    Created on : 17-Mar-2015, 18:24:56
    Author     : Robert
--%>
<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>


<html>
    <head>
        <title>error</title>
    </head>
    <body>
        <h1>Exception Details:</h1>
        <%=exception.toString()%>
    </body>
</html>
