<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <link href="css/simple.css" rel="stylesheet"/>
    <meta charset="UTF-8">
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Registrering</title>
</head>

<body>
<h2>Register</h2>
<p style="color:red;">${}</p>
<form method="post" action="/register">
    <fieldset>

        <label>Fornavn</label>
        <input type="text" name="fornavn" required pattern="[A-ZØÆÅ][A-ZÆØÅa-zæøå -]{1,19}" title="Første bokstav skal være stov, 2-20 tegn"/>

        <label>Etternavn</label>
        <input type="text" name="etternavn" required pattern="[A-ZØÆÅ][A-ZÆØÅa-zæøå-]{1,19}" title="Første bokstav skal være stov, 2-20 tegn, ingen mellomrom"/>

        <label>Mobil (8 siffer)</label>
        <input type="text" name="mobil" required pattern="[0-9]{8}" title="8 siffer"/>

        <br><br><button type="submit">Register yourself!</button>
    </fieldset>
</form>

</body>
</html>