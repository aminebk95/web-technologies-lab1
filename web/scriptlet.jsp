<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Scriptlet</title>
</head>
<body>
<%
    java.util.Date date = new java.util.Date();
    out.println("<p>Current time: " + date + "</p>");
    out.println("<p>IP address: " + request.getRemoteHost() + "</p>");
%>
<p><a href="index.html">Back</a></p>
</body>
</html>
