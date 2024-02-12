<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Registrering</title>
</head>

<body>
<h2>Register</h2>
<c:if test="${error != null}">
	<p style="color: red;">${error}</p>
</c:if>
<c:if test="${success != null}">
	<p>${success}</p>
</c:if>
<form method="post" action="/lagre-bruker">
    <fieldset>

        <label>
            Fornavn
            <input type="text" name="name" required pattern="[A-ZØÆÅ][A-ZÆØÅa-zæøå -]{1,19}" title="Første bokstav skal være stov, 2-20 tegn">
        </label>
        <br>
        <label>
            Etternavn
            <input type="text" name="surname" required pattern="[A-ZØÆÅ][A-ZÆØÅa-zæøå-]{1,19}" title="Første bokstav skal være stov, 2-20 tegn, ingen mellomrom">
        </label>
        <br>
        <label>
            Mobil (8 siffer)
            <input type="text" name="phone" required pattern="\d{8}" title="8 siffer">
        </label>
        <br>
        <label>
            Adresse
            <input type="text" name="address" required pattern="[a-zæøåA-ZÆØÅ -]{5,30} \d{1,4}[A-Za-z]?" title="Gyldig addresse">
        </label>
        <br>
        <label>
            Postnummer
            <input type="text" name="postnum" required pattern="\d{4}" title="4 siffer">
        </label>

        <br><br><button type="submit">Legg til bruker!</button>
    </fieldset>
</form>

</body>
</html>