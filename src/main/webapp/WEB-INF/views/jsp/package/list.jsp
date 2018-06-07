<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Cities</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Cities</th>
            <th>Places</th>
        </tr>
        </thead>

        <c:forEach var="package" items="${packages}">
            <tr>
                <td>${package.packageID}</td>
                <td>${package.packageName}</td>
                <td><c:forEach var="city" items="${package.cities}" varStatus="loop">
                    ${city}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach></td>
                <td><c:forEach var="places" items="${package.places}" varStatus="loop">
                    ${places}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach></td>
                <td>
                    <spring:url value="/packages/${package.packageID}" var="packageUrl"/>
                    <spring:url value="/packages/${package.packageID}/delete" var="deleteUrl"/>
                    <spring:url value="/packages/${package.packageID}/update" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${packageUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
