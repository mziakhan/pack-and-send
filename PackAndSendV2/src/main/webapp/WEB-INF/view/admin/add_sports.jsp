<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@include file="../common/include.jsp"%>
<title>CIP | Sports Master</title>
<style>
.inline {
	display: inline; . wrapper { min-height : 100%;
	height: auto !important;
	height: 100%;
	margin: 0 auto;
	/* the bottom margin is the negative value of the footer's height */
}
}
</style>
</head>

<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<c:if test="${param.successMsg!=null}">
			<div class="alert alert-success" id="msgAlert">${param.successMsg}</div>
		</c:if>
		<c:if test="${sessionScope.errorMsg!=null}">
			<div class="alert alert-danger" id="msgAlert">${sessionScope.errorMsg}</div>
		</c:if>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Add Sports</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="action?requestUrl=saveSports" method="post">
					<div class="form-group">
						<label class="control-label col-md-6" for="email"> Sports
							Name:</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="sportsName"
								placeholder="Enter Sports Name">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success">Add</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>




</body>
</html>

