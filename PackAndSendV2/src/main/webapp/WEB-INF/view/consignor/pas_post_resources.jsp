<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Pack 'N Send| Resources</title>
<%@include file="../common/include.jsp"%>

<style>
.dropdown-menu {
	width: 30px !important;
	height: 10px !important;
}

.form-row {
	margin-top: 20px;
}
</style>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title" style="margin-top: 25px;">
					Post Resources | <small>Post Vehicle and Driver details</small>
				</h3>
			</div>

			<div id="exTab2" style="margin-top: 25px;">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active" href="#tab1"
						data-toggle="tab">Add Vehicle</a></li>
					<li><a class="nav-link" href="#tab2" data-toggle="tab">Add
							Driver</a></li>
				</ul>
				<div class="tab-content ">
					<div class="tab-pane active" id="tab1">
						<%@include file="../consignor/pas_post_vehicle_resources.jsp"%>
					</div>
					<div class="tab-pane" id="tab2">
						<%@include file="../consignor/pas_post_driver_resources.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>
</body>
</html>