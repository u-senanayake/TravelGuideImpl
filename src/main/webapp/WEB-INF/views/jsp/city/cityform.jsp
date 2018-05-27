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
        <c:when test="${cityForm['new']}">
            <h1>Add City</h1>
        </c:when>
        <c:otherwise>
            <h1>Update City</h1>
        </c:otherwise>
    </c:choose>
    <br/>

    <spring:url value="/cities" var="userActionUrl"/>

    <form:form class="form-horizontal" method="post" modelAttribute="cityForm" action="${userActionUrl}">

        <form:hidden path="cityID"/>

        <spring:bind path="cityName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">City Name</label>
                <div class="col-sm-10">
                    <form:input path="cityName" type="text" class="form-control " id="cityNamre" placeholder="Name"/>
                    <form:errors path="cityName" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="cityDescription">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:input path="cityDescription" class="form-control" id="cityDescription"
                                placeholder="Description"/>
                    <form:errors path="cityDescription" class="control-label"/>
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
        <spring:bind path="cityImgUrl">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Image URL</label>
                <div class="col-sm-10">
                    <form:input path="cityImgUrl" class="form-control" id="cityImgUrl" placeholder="Description"/>
                    <form:errors path="cityImgUrl" class="control-label"/>
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
                    <c:when test="${cityForm['new']}">
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
