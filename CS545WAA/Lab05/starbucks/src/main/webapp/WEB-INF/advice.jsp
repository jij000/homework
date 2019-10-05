<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Starbuck's</title>
</head>
<body>
<h2>Ask for advice about your favorite roast:</h2>
<p>${user.name}</p>
<c:if test="${user.name ne null}">
    <form action="logout" method="post">
        <input type="submit" value="logout"/>
    </form>
</c:if>
<form action="advice" method="post">
    <select name="roast">

        <c:forEach var="roast" items="${roasts}">
            <option value="${roast.value}"> ${roast.key}</option>
        </c:forEach>

    </select>

    <p><input type="submit" value="Submit"/></p>
</form>

</body>
</html>