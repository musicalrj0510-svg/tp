// File: test.java
<%-- 
    Document   : test
    Created on : 5 Feb, 2026, 5:18:40 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Use of Intrinsic Objects in JSP</h1>
        <h2>Request Object</h2>
        Query String <%=request.getQueryString() %> <br>
        Context Path <%=request.getContextPath() %> <br>
        Remote Host <%=request.getRemoteHost() %> <br>
        
        <h1>Response object</h1>
        Character Encoding Type <%=request.getCharacterEncoding() %> <br>
        Context Type <%=request.getContextPath() %> <br>
        Locale <%=request.getLocale() %> <br>
        <h1>Session Object</h1>
        ID <%=session.getId() %> <br>
        Creation Time <%=new java.util.Date(session.getCreationTime()) %> <br>
         Last Access Time <%=new java.util.Date(session.getLastAccessedTime()) %> <br>
    </body>
</html>