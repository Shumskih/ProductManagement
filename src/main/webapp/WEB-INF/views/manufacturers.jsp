<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>List Of Manufacturers</title>
    <%@ include file="../../resources/details/head.jsp" %>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1 class="text-center">List Of Manufacturers</h1>

<c:if test="${!empty listOfManufacturers}">
    <table  class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOfManufacturers}" var="manufacturer">
            <tr>
                <td>${manufacturer.id}</td>
                <td><a href="/manufacturer-data/${manufacturer.id}" target="_blank">${manufacturer.name}</a></td>
                <td><a href="<c:url value='/manufacturers/edit/${manufacturer.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/manufacturers/remove/${manufacturer.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<h1>Add a Manufacturer</h1>

<c:url var="addAction" value="/manufacturers/add"/>

<form:form action="${addAction}" modelAttribute="manufacturer">
    <table class="table">
        <c:if test="${!empty manufacturer.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty manufacturer.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Manufacturer"/>"/>
                </c:if>
                <c:if test="${empty manufacturer.name}">
                    <input type="submit"
                           value="<spring:message text="Add Manufacturer"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<%@ include file="../../resources/details/javascript.jsp" %>
</body>
</html>



