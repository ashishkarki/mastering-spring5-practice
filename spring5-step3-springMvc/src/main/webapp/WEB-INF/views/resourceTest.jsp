<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<c:url value="/resources/myCss.css" />" rel="stylesheet">

    <script src= "webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <link href='<spring:url value="/styles/myCss.css"/>' rel="stylesheet" />
    <link href='<c:url value="/styles/myCss.css"/>' rel="stylesheet" />
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/styles/myCss.css">
    <title>Home</title>
</head>
<body>
    <h1>Hello world!</h1>

    <p class="well">
        <p class="panel panel-info">
            hello this is the bootstrap class using WebJars
        </p>
    </p>
</body>
</html>