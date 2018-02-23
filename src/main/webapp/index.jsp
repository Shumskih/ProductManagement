<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductManagementSystem</title>
    <%@ include file="resources/details/head.jsp" %>
</head>
<body>
<h3>ProjectManagementSystem</h3>
<br/>
<div>
    <a href="<c:url value="/login"/>">Login</a>
</div>
<div>
    <a href="<c:url value="/registration"/>">Registration</a>
</div>
<div>
    <a href="<c:url value="/products"/>">Products list</a>
</div>
<div>
    <a href="<c:url value="/manufacturers"/>">Manufacturers list</a>
</div>
<br/>
<%@ include file="resources/details/javascript.jsp" %>
</body>
</html>
