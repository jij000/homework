<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@page errorPage="loginerror.jsp"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h2>Ask for advice about your favorite roast:</h2>
<p/>
<form action="advice" method="post">
    <select name="roast"
            <c:if test="${user.name eq null}">disabled="disabled"</c:if> >
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value="Submit"
           <c:if test="${user.name eq null}">disabled="disabled"</c:if> />
</form>

<p/>
<c:if test="${user.name eq null}">
    <form action="login" method="post">
        <p><c:out value="${error}"></c:out></p>
        <p>Login: </p>
        <p> Name : <input type="text" id="name" name="name"/></p>
        <p> Password : <input type="password" id="password" name="password"/></p>
        <p><input type="submit" value="login"/></p>
    </form>
</c:if>
<c:if test="${user.name ne null}">
    <form action="logout" method="post">
        <input type="submit" value="logout"/>
    </form>
</c:if>
</body>
</html>