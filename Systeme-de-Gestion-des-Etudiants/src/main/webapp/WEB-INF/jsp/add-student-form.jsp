<%--
  Created by IntelliJ IDEA.
  User: PCPACK
  Date: 08/05/2024
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajouter un Nouvel Étudiant</h1>
<form action="${pageContext.request.contextPath}/students/add">
    <label>Nom :</label>
    <input type="text" name="name" required><br>
    <label>Numéro de Matricule :</label>
    <input type="text" name="studentNumber" required><br>
    <label>Email :</label>
    <input type="email" name="email" required><br>
    <input type="submit" value="Ajouter">
</form>

</body>
</html>
