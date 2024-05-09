<%--
  Created by IntelliJ IDEA.
  User: PCPACK
  Date: 08/05/2024
  Time: 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Mettre à Jour les Détails de l'Étudiant</h1>
<form action="${pageContext.request.contextPath}/students/update/${student.id}" method="post">
    <label>Nom :</label>
    <input type="text" name="name" value="${student.name}" required><br>
    <label>Numéro de Matricule :</label>
    <input type="text" name="studentNumber" value="${student.studentNumber}" required><br>
    <label>Email :</label>
    <input type="email" name="email" value="${student.email}" required><br>
    <input type="submit" value="Mettre à Jour">
</form>
</body>
</html>
