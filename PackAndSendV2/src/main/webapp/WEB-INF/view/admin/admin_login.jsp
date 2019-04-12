<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<div class="panel panel-default border">
	<div class="panel-heading">
		<h3 class="panel-title">Admin Login</h3>
	</div>
	<div class="panel-body">
		<%@include file="../common/alert.jsp"%>
		<form class="form-horizontal" action="${action}" commandName="command"
			method="post">
			<div class="form-group">
				<label class="control-label col-md-6">Username:</label>
				<div class="col-md-10">
					<input type="text" class="form-control" name="userName"
						placeholder="Enter User Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-6">Password:</label>
				<div class="col-md-10">
					<input type="text" class="form-control" name="password"
						placeholder="Enter Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Sign in</button>
					<a class="btn btn-primary" href="./signup" type="button">Sign
						up </a>
				</div>
			</div>
		</form>
	</div>
</div>