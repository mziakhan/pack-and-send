<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Pack 'N Send| Add Details</title>
<%@include file="../common/include.jsp"%>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
	<%@include file="../common/alert.jsp"%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Add Company</h3>
			</div>
			<div class="panel-body">
				<form action="${action}" commandName="command" method="post">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label>Name</label> <input type="text" class="form-control"
								id="companyName" name="companyName" placeholder="Company name">
						</div>
						<div class="form-group col-md-6">
							<label>Contact</label> <input type="text" class="form-control"
								id="contactNo" name="contactNo" placeholder="Contact No">
						</div>
						<div class="form-group col-md-6">
							<label>Email Address</label> <input type="text"
								class="form-control" id="email" name="email"
								placeholder="Email Address">
						</div>
						<div class="form-group col-md-6">
							<label>Pan No</label> <input type="text" class="form-control"
								id="panNo" name="panNo" placeholder="Pan No">
						</div>
						<div class="form-group col-md-6">
							<label>Website</label> <input type="text" class="form-control"
								id="website" name="website" placeholder="Website">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Add Company</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>