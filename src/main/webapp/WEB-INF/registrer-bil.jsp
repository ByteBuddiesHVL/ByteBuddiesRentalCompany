<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Registrer bil</title>
</head>

<body>
<h2>Registrer bil</h2>
<c:if test="${error != null}">
	<p style="color: red;">${error}</p>
</c:if>
<c:if test="${success != null}">
	<p>${success}</p>
</c:if>
<form method="post" action="/lagre-bil">
    <fieldset>

		<label>
				Skiltnummer
				<input name="regNum" required pattern="[A-Z]{2} \d{5}" title="Må være et gyldig skiltnummer">
			</label>
			<br>
		<label>
				Bilmerke
				<input name="brand" required>
			</label>
			<br>
		<label>
				Farge
				<input name="color" required>
			</label>
			<br>
		<label>
			Kilometer kjørt
			<input type="number" name="km" required min="0" max="9999999">
		</label>
		<br>
		<p>Gruppe:</p>
		<label>
			<input type="radio" value="A" name="group" required>
			Liten bil
		</label>
		<br>
		<label>
			<input type="radio" value="B" name="group" required>
			Mellomstor bil
		</label>
		<br>
		<label>
			<input type="radio" value="C" name="group" required>
			Stor bil
		</label>
		<br>
		<label>
			<input type="radio" value="D" name="group" required>
			Varebil
		</label>

		<p>Utleiekontor:</p>

		<c:forEach items="${locations}" var="loc">
			<label>
				${loc.address}
				<input type="radio" name="locations" value="${loc.tlfNum}" required>
			</label>
			<br>
		</c:forEach>

        <br><button type="submit">Registrer bil</button>
    </fieldset>
</form>

</body>
</html>