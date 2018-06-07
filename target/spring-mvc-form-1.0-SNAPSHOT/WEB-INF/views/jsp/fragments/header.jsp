<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>Travel Guide</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/core/css/dataTables.bootstrap4.min.css" var="dataTable"/>
    <spring:url value="/resources/core/css/font-awesome.min.css" var="fontAwesome"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${dataTable}" rel="stylesheet">
    <link href="${fontAwesome}" rel="stylesheet">

</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/users/add" var="urlAddUser"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddUser}">Add User</a></li>
            </ul>
        </div>
    </div>
</nav>