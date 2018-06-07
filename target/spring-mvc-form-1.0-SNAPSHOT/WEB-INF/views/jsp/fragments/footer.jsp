<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
	<hr>
	<footer>
		<p>&copy; Udayanga </p>
	</footer>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">

</script>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/dataTables.bootstrap4.min.js" var="dataTableBootstrap"/>
<spring:url value="/resources/core/js/jquery.dataTables.min.js" var="dataTableJquery"/>
<spring:url value="/resources/core/js/jquery-3.3.1.js" var="jquery" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="${dataTableBootstrap}"></script>
<script src="${dataTableJquery}"></script>
<script src="${jquery}"></script>



