<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@include file="common/include.jsp"%>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Pack'N Send | Login</title>
<style>
.inline {
	display: inline; . wrapper { min-height : 100%;
	height: auto !important;
	height: 100%;
	margin: 0 auto;
	/* the bottom margin is the negative value of the footer's height */
}

}
#parent_div_1, #parent_div_2 {
	width: 500px;
	/* 	border: 1px solid red; */
	margin-right: 20px;
	float: left;
}

#wrapper {
	margin-top: 50px;
}

h3 {
	margin-left: 12px;
	margin-top: 10px;
}

.mycontent-left {
	margin-left: 5px;
	border-right: 1px solid #bdbdbd;
}
</style>
</head>

<body>
	<div class="container">
		<c:if test="${param.successMsg!=null}">
			<div class="alert alert-success" id="msgAlert">${param.successMsg}</div>
		</c:if>
		<c:if test="${sessionScope.errorMsg!=null}">
			<div class="alert alert-danger" id="msgAlert">${sessionScope.errorMsg}</div>
		</c:if>
		<div class="col-md-12" id="wrapper">
			<div id="parent_div_1" class="mycontent-left">
				<%@include file="./admin/admin_login.jsp"%>
			</div>
			<div id="parent_div_2" class="mycontent-left"><%@include
					file="./common/user_services.jsp"%></div>

		</div>
	</div>
</body>
</html>

