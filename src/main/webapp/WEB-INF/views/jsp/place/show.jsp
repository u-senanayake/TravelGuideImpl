<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Place Detail</h1>
	<br />

	<div class="row">

		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${place.placeId}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">${place.placeName}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Description</label>
		<div class="col-sm-10">${place.placeDescription}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Type</label>
		<div class="col-sm-10">${place.placeType}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Rate</label>
		<div class="col-sm-10">${place.rate}</div>
	</div>

    <div class="row">
        <label class="col-sm-2">City</label>
        <div class="col-sm-10">${place.cityId}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Image</label>
        <div class="col-sm-10">${place.placeImgUrl}</div>
    </div>


</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
