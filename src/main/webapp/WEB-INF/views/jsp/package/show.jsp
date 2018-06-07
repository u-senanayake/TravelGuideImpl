<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Package Detail</h1>
    <div class="row">
        <label class="col-sm-2">Name</label>
        <div class="col-sm-10">${package.packageName}</div>
    </div>
    <table class="table table-striped table-bordered">
        <tr>
            <td width="80%">
                <div>
                    <h1>Places</h1>
                    <table class="table table-striped table-bordered">
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
                                <td><img src="${place.placeImgUrl}"></td>
                                <td>
                                    <spring:url value="/places/${package.packageID}/${place.placeId}/delete"
                                                var="deleteUrl"/>
                                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="">Edit Places</button>
                </div>
            </td>
            <td width="20%" rowspan="3">test2</td>
        </tr>
        <tr>
            <td>
                <div>
                    <h1>Hotels</h1>
                    <table class="table table-striped table-bordered">
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
                                <td><img src="${place.placeImgUrl}"></td>
                                <td>
                                    <spring:url value="/places/${package.packageID}/${place.placeId}/delete"
                                                var="deleteUrl"/>
                                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="">Edit Hotels</button>

                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <h1>Transport</h1>
                    <table class="table table-striped table-bordered">
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
                                <td><img src="${place.placeImgUrl}"></td>
                                <td>
                                    <spring:url value="/places/${package.packageID}/${place.placeId}/delete"
                                                var="deleteUrl"/>
                                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button class="btn btn-primary" onclick="">Edit Transport</button>
                </div>
            </td>
        </tr>
    </table>
    <br/>


</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
