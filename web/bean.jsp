<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%-- creer le bean et le remplir avec les parametres du formulaire --%>
<jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />
<jsp:setProperty name="person" property="*" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bean</title>
</head>
<body>
<h2>Information saved in the bean</h2>

<%-- lire les valeurs depuis le bean --%>
<table border="1">
    <tr><th>First name</th><td><jsp:getProperty name="person" property="firstName" /></td></tr>
    <tr><th>Last name</th><td><jsp:getProperty name="person" property="lastName" /></td></tr>
    <tr><th>Birth day</th><td><jsp:getProperty name="person" property="birthDay" /></td></tr>
    <tr><th>Sex</th><td><jsp:getProperty name="person" property="sex" /></td></tr>
</table>

<p><a href="form-jsp.html">Back</a></p>
</body>
</html>
