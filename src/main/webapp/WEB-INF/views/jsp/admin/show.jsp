<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="../fragments/header.jsp"/>

<div class="container">

    <h1>Admin Panel</h1>
    <br/>

    <div class="row">
        <spring:url value="/users/add" var="userAdd"/>
        <spring:url value="/users" var="user"/>
        <h4>User</h4>
        <button class="btn btn-primary" onclick="location.href='${userAdd}'">Add User</button>
        <button class="btn btn-primary" onclick="location.href='${user}'">View User</button>
    </div>

    <div class="row">
        <spring:url value="/cities/add" var="cityAdd"/>
        <spring:url value="/cities" var="city"/>
        <h4>City</h4>
        <button class="btn btn-primary" onclick="location.href='${cityAdd}'">Add City</button>
        <button class="btn btn-primary" onclick="location.href='${city}'">View City</button>
    </div>

    <div class="row">
        <spring:url value="/places/add" var="placeAdd"/>
        <spring:url value="/places" var="place"/>
        <h4>Place</h4>
        <button class="btn btn-primary" onclick="location.href='${placeAdd}'">Add Place</button>
        <button class="btn btn-primary" onclick="location.href='${place}'">View Place</button>
    </div>

    <div class="row">
        <spring:url value="/hotels/add" var="hotelAdd"/>
        <spring:url value="/hotels" var="hotel"/>
        <h4>Hotel</h4>
        <button class="btn btn-primary" onclick="location.href='${hotelAdd}'">Add Hotel</button>
        <button class="btn btn-primary" onclick="location.href='${hotel}'">View Hotel</button>
    </div>



</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
