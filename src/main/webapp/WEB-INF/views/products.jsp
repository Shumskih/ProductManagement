<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>List Of Products</title>
    <%@ include file="../../resources/details/head.jsp" %>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1 class="text-center">List Of Products</h1>

<c:if test="${!empty listOfProducts}">
    <table  class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Manufacturer</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOfProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><a href="/product-data/${product.id}" target="_blank">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.manufacturer.name}</td>
                <td><a href="<c:url value='/products/edit/${product.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/products/remove/${product.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<h1>Add a Product</h1>

<c:url var="addAction" value="/products/add"/>

<form:form action="${addAction}" modelAttribute="product">
    <table class="table">
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="20" disabled="true"/>
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
            <td>
                <form:label path="price">
                    <spring:message text="price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="manufacturer">
                    <spring:message text="Select Manufacturer"/>
                </form:label>
                <form:select path="manufacturer" class="form-control">
                    <form:options items="${manufacturers}" itemValue="id" itemLabel="name"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>"/>
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<%@ include file="../../resources/details/javascript.jsp" %>
</body>
</html>


