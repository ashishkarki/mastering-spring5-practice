List of all users....
<br />
< hr />

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Spring MVC internationalization example</h1>

Language : <a href="?language=en">English</a>|
<a href="?language=fr">French</a>

<h3>
	welcome.springmvc :<spring:message code="welcome.springmvc" text="default text" />
	message.caption:: <spring:message code="message.caption" text="welcome default" />
</h3>


Current Locale : ${pageContext.response.locale}