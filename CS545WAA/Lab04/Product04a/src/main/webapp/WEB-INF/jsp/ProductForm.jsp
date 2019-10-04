<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
    <form:form modelAttribute="product" action="product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="category"><spring:message code="category" /> </label>
                <form:select id="category" path="category.id">
                    <form:option value="0"> --Select Category--</form:option>
                    <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                </form:select>
            </p>

            <p>
                <label for="name"><spring:message code="name" />: </label>
                <form:input type="text" id="name" path="name"
                            tabindex="1"></form:input>
            </p>
            <p>
                <label for="description"><spring:message code="description" />: </label>
                <form:input type="text" id="description" value="${product.description}"
                            path="description" tabindex="2"></form:input>
            </p>
            <p>
                <label for="price"><spring:message code="price" />: </label>
                <form:input type="text" id="price" path="price"
                            tabindex="3"></form:input>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
