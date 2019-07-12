<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
<c:if test="${msg == 'Update'}">
    <c:set var="action" scope="page" value="../books/${book.id}"/>
</c:if>
<c:if test="${msg == 'Add'}">
    <c:set var="action" scope="page" value="../books"/>
</c:if>
<form:form modelAttribute="book" action="${action}" method="post">
    <form:errors path="*" cssClass="errorblock" element="div"/>
    <table>
        <tr>
            <td>Title:</td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title" cssClass="error"/></td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td><form:input path="ISBN"/></td>
            <td><form:errors path="ISBN" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author"/></td>
            <td><form:errors path="author" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"/></td>
            <td><form:errors path="price" cssClass="error"/></td>
        </tr>
    </table>
    <input type="submit"/>
</form:form>
<c:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
</c:if>
</body>

</html>