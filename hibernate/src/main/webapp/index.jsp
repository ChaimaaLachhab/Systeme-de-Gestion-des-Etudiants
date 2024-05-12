<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Application</title>
</head>
<body>
<h1>Bienvenue sur mon application</h1>
<p>Ceci est la page d'accueil de mon application.</p>

<a href="${pageContext.request.contextPath}/students">Voir la liste des étudiants</a>

<!-- Lien vers la page d'ajout d'étudiant -->
<a href="${pageContext.request.contextPath}/add">Ajouter un étudiant</a>
</body>
</html>
