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
<form method="get" action="/reserver">
    <fieldset>

		<select name="user">
			<c:forEach items="${users}" var="user">
				<option value="${user.tlfNum}">
					${user.firstName} ${user.lastName}
				</option>
			</c:forEach>
		</select>
		<br>

		<label>
			Startdato
			<input type="datetime-local" name="startDate" required>
		</label>
		<br>
		<label>
			Sluttdato
			<input type="datetime-local" name="endDate" required>
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

		<p>Startlokasjon:</p>
		<c:forEach items="${locations}" var="loc">
			<label>
				${loc.address}
				<input type="radio" name="startLocation" value="${loc.tlfNum}" required>
			</label>
		</c:forEach>

        <br><br><button type="submit">Registrer reservasjon</button>
    </fieldset>
</form>
<script>
	const form = document.forms[0]
	const startDateInput = form.startDate
	const endDateInput = form.endDate
	form.getElementsByTagName("button")[0].onclick = () => {
		const startDate = startDateInput.valueAsNumber
		const endDate = endDateInput.valueAsNumber
		startDateInput.setCustomValidity(startDate < Date.now() ? "Start dato kan ikke være i fortiden" : "")
		endDateInput.setCustomValidity(startDate < endDate ? "" : "Start dato må være før slutt dato")
	}
</script>
</body>
</html>