<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="include.jsp"%>
<title>Sign up</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Sign up</h3>
			</div>
			<div class="panel-body">
				<form action="RegistrationServlet" method="post">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputUserName">Name</label> <input type="text"
								class="form-control" id="name" name="name"
								placeholder="Set username">
						</div>
						<div class="form-group col-md-6">
							<label for="inputUserName">Username</label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="Set username">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">Password</label> <input
								type="password" class="form-control" id="password"
								name="password" placeholder="Password">
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail4">Email</label> <input type="email"
								class="form-control" id="email" name="email"
								placeholder="email address">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Sign up</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>