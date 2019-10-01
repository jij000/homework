<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head></head>
<body>
<form action="../action/login" method="get">

    Starbuck's
    <c:out value="${fn:toUpperCase(roast)}"></c:out> Roast Coffees:

    <table>
        <c:forEach var="adv" items="${advice}" varStatus="row">
            <c:if test="${row.index%2 eq 0 }">
                <tr style="background-color:cyan">
            </c:if>
            <c:if test="${row.index%2 eq 1 }">
                <tr style="background-color:yellow">
            </c:if>
            <td><c:out value="${adv}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" value="Back">
</body>
</html>