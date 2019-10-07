<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<h1>Registration Form</h1><br/>
<section class="container">
    <form:form modelAttribute="student" class="form-horizontal">
        <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
        <fieldset>
            <legend>Register a new student</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="firstName">
                    First Name
                </label>
                <div class="col-lg-10">
                    <form:input path="firstName" id="firstName"
                                class="form:input-large"/>
                    <form:errors path="firstName" cssClass="text-danger"></form:errors>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="lastName">
                    Last name
                </label>
                <div class="col-lg-10">
                    <form:input path="lastName" id="lastName" class="form:input-large"/>
                    <form:errors path="lastName" cssClass="text-danger"></form:errors>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="email">Email</label>
                <div class="col-lg-10">
                    <form:input path="email" id="email"
                                class="form:input-large"/>
                    <form:errors path="email" cssClass="text-danger"></form:errors>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="gender">Gender</label>
                <div class="col-lg-10">
                    <form:input path="gender" id="gender" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="phone">Phone</label>
                <div class="col-lg-10">
                    <form:input path="phone" id="phone"
                                class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Register"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>