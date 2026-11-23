<%@ page contentType="text/html;charset=UTF-8" %>

<%-- type= : la JSP ne cree pas le bean, elle utilise celui ajoute par le Controller --%>
<jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Old</title>
</head>
<body>
<h2>You were born before 1990</h2>

<table border="1">
    <tr><th>First name</th><td><jsp:getProperty name="person" property="firstName" /></td></tr>
    <tr><th>Last name</th><td><jsp:getProperty name="person" property="lastName" /></td></tr>
    <tr><th>Birth day</th><td><jsp:getProperty name="person" property="birthDay" /></td></tr>
    <tr><th>Sex</th><td><jsp:getProperty name="person" property="sex" /></td></tr>
</table>

<p><a href="mvc/index.html">Back</a></p>
</body>
</html>
