<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Reserver bil</title>
</head>

<body>
<h2>Reserver bil</h2>
<c:if test="${error != null}">
	<p style="color: red;">${error}</p>
</c:if>
<c:if test="${success != null}">
	<p>${success}</p>
</c:if>
<form method="post" action="/lagre-reservasjon">
    <fieldset>

		<input type="hidden" name="user" value="${user}">
		<input type="hidden" name="startDate" value="${startDate}">
		<input type="hidden" name="endDate" value="${endDate}">
		<input type="hidden" name="price" value="${price}">

		<label>
			Kortnummer
			<input name="cardNumber" required pattern="\d{4} ?\d{4} ?\d{4} ?\d{4}">
		</label>
		<br>

		<label>
			Kortkode
			<input name="cardCode" required pattern="\d{3}">
		</label>
		<br>

		<p>Bil:</p>
		<c:forEach items="${cars}" var="car">
			<label>
				${car.brand} - ${car.regNum} : ${price}kr
				<input type="radio" name="car" value="${car.regNum}" required>
			</label>
		</c:forEach>
		<br>

		<p>Sluttlokasjon:</p>
		<c:forEach items="${locations}" var="loc">
			<label>
					${loc.address}
				<input type="radio" name="location" value="${loc.tlfNum}" required>
			</label>
			<br>
		</c:forEach>

        <br><button type="submit">Registrer reservasjon</button>
    </fieldset>
</form>
</body>
</html>