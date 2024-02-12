<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Lever inn bil</title>
</head>

<body>

    <c:if test="${error != null}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${success != null}">
        <p>${success}</p>
    </c:if>

    <form method="post" action="/lever">
        <select name="reservation">
            <c:forEach items="${reservations}" var="res">
                <option value="${res.reservationId}">
                        ${res.reservationId}
                </option>
            </c:forEach>
        </select>

        <br><br><button type="submit">Lever inn bil</button>
    </form>

</body>
