<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp"/>

<div class="container">

    <c:choose>
        <c:when test="${placeForm['new']}">
            <h1>Add City</h1>
        </c:when>
        <c:otherwise>
            <h1>Update City</h1>
        </c:otherwise>
    </c:choose>
    <br/>

    <spring:url value="/places" var="placeActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="placeForm" action="${placeActionUrl}">

        <form:hidden path="placeId"/>

        <spring:bind path="placeName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">City Name</label>
                <div class="col-sm-10">
                    <form:input path="placeName" type="text" class="form-control " id="placeName" placeholder="Name"/>
                    <form:errors path="placeName" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="placeDescription">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:input path="placeDescription" class="form-control" id="placeDescription"
                                placeholder="Description"/>
                    <form:errors path="placeDescription" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="placeType">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Type</label>
                <div class="col-sm-10">
                    <form:input path="placeType" class="form-control" id="placeType"
                                placeholder="Type"/>
                    <form:errors path="placeType" class="control-label"/>
                </div>
            </div>

        </spring:bind><spring:bind path="cityId">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">City ID</label>
            <div class="col-sm-10">
                <form:input path="cityId" class="form-control" id="cityId"
                            placeholder="City ID"/>
                <form:errors path="cityId" class="control-label"/>
            </div>
        </div>
    </spring:bind>

        <spring:bind path="rate">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Rate</label>
                <div class="col-sm-10">
                    <form:radiobuttons path="rate" items="${numberList}" element="label class='radio-inline'"/>
                    <br/>
                    <form:errors path="rate" class="control-label"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="placeImgUrl">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Image URL</label>
                <div class="col-sm-10">
                    <form:input path="placeImgUrl" class="form-control" id="placeImgUrl" placeholder="Description"/>
                    <form:errors path="placeImgUrl" class="control-label"/>
                </div>
            </div>
        </spring:bind>
        <!-- Custom Script, Spring map to model via 'name' attribute
        <div class="form-group">
        <label class="col-sm-2 control-label">Number</label>
        <div class="col-sm-10">

        <c:forEach items="${numberList}" var="obj">
            <div class="radio">
            <label>
            <input type="radio" name="number" value="${obj}">${obj}
            </label>
            </div>
        </c:forEach>
        </div>
        </div>
        -->


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${placeForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
