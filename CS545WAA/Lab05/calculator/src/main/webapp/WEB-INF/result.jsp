<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Calculate</title>
</head>

<body>
<p><c:out value="${msg}"></c:out></p>
<c:forEach var="err" items="${errors}">
    <p><c:out value="${err}"></c:out></p>
</c:forEach>
<form action="CalculatorPost" method="post">
    <input type="text" name="add1" size="2" value="${calculator.add1}" />+
    <input type="text" name="add2" value="${calculator.add2}" size="2" />=
    <input type="text" name="sum" value="${calculator.sum}" size="2" readonly /><br />
    <input type="text" name="mult1" value="${calculator.mult1}" size="2" />*
    <input type="text" name="mult2" value="${calculator.mult2}" size="2" />=
    <input type="text" name="product" value="${calculator.product}" size="2" readonly /><br />
    <input type="submit" value="Submit" />
</form>
</body>

</html>