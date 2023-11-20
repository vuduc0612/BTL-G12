<%-- 
    Document   : test
    Created on : Nov 19, 2023, 7:30:49 AM
    Author     : huuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String data = "Du lieu";
        session.setAttribute("dataKey", data);
        %>
        <h1>Hello World!</h1>
    </body>
</html>
