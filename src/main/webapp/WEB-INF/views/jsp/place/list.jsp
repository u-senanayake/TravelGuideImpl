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

    <h1>All Places</h1>

    <table id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Type</th>
            <th>Rate</th>
            <th>City Id</th>
            <th>Img</th>

        </tr>
        </thead>

        <c:forEach var="place" items="${places}">
            <tr>
                <td>${place.placeId}</td>
                <td>${place.placeName}</td>
                <td>${place.placeDescription}</td>
                    <%--<td><c:forEach var="framework" items="${user.framework}" varStatus="loop">--%>
                    <%--${framework}--%>
                    <%--<c:if test="${not loop.last}">,</c:if>--%>
                    <%--</c:forEach></td>--%>
                    <%--<td>--%>
                <td>${place.placeType}</td>
                <td>${place.rate}</td>
                <td>${place.cityId}</td>
                <td>${place.placeImgUrl}</td>
                <td>
                    <spring:url value="/places/${place.placeId}" var="packageUrl"/>
                    <spring:url value="/places/${place.placeId}/delete" var="deleteUrl"/>
                    <spring:url value="/places/${place.placeId}/update" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${packageUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
