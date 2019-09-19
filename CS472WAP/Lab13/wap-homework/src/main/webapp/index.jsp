<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>The Number Quiz</title>
</head>

<body>
<h1>The Number Quiz</h1>
<p>Your current score is <c:out value="${quiz.score}"/>.</p>
<c:if test="${qIndex eq -1}">
    <p>You hava completed the Number Quiz, with a score of <c:out value="${quiz.score}"></c:out> of <c:out
            value="${fn:length(questions)}"></c:out>.</p>
</c:if>
<c:if test="${qIndex ne -1}">
    <p>Guess the next number in the sequence.</p>
    <p><c:out value="${questions[qIndex]}"></c:out></p>
    <form action="Quiz" method="POST">
        <label>Your ansewer: </label><input type="number" id="ans" name="ans"/>
        <input type="submit" id="submit" name="submit" value="submit"/>
    </form>
</c:if>
</body>

</html>