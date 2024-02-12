<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Hjemmeside</title>
</head>

<body>
    <c:if test="${success != null}">
        <p>${success}</p>
    </c:if>
    <h2>Velkommen til ${comp.name}</h2>

    <a href="/registrer-bil">Registrer en bil! (ONLY ADMINS)</a>
    <br>
    <a href="/lever">Lever inn bil! (ONLY ADMINS)</a>
    <br>
    <a href="/registrer">Registrer deg selv!</a>
    <br>
    <a href="/start-reservasjon">Reserver en bil!</a>

</body>
