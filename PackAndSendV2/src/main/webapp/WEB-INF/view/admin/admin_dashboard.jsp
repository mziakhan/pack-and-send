<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<%@include file="../common/include.jsp"%>
<style>
.ma {
	padding-top: 60px;
}

@media ( max-width : 980px) {
	.ma {
		padding-top: 0;
	}
}
</style>
</head>
<body>
	<form action="AdminActionServlet">
		<%@include file="../common/header.jsp"%>
		<div class="container ma">
			<div class="card-deck">
				<div class="card border-secondary mb-3" style="max-width: 18rem;">
					<div class="card-header">Total Books</div>
					<div class="card-body text-secondary">
						<h5 class="card-title">2</h5>
						
					</div>
				</div>
				<div class="card border-secondary mb-3" style="max-width: 18rem;">
					<div class="card-header">Total Users</div>
					<div class="card-body text-secondary">
						<h5 class="card-title">1</h5>
						
					</div>
				</div>



			</div>
		</div>

	</form>

	<%@include file="../common/footer.jsp"%>
</body>

</html>