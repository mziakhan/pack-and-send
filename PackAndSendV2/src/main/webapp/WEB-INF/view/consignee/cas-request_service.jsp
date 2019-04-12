<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Pack 'N Send| Process Consignment</title>
<%@include file="../common/include.jsp"%>
<script>
	function fetchVehicleList(companyId) {
		console.log(companyId);
		$.ajax({
			url : 'searchVehiceList',
			data : {
				companyId : companyId
			},
			success : function(list) {
				var opt = '<option value="">--Choose Vehicle--</option>';
				for (i in list) {
					opt += '<option value="' + list[i].vehicleId + '">' + list[i].make+"-->"+list[i].vehicleType + '</option>';
				}
				 $('#vehicleId').html(opt);
			}
		});

	}
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="container">
	<%@include file="../common/alert.jsp"%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Post Load</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="services?s=2" method="post">
					<div class="form-group col-md-8">
						<label class="control-label ">Select Consignor </label> <select
							id="companyId" name="companyId" class="form-control"
							onchange="fetchVehicleList(this.value)">
							<option value="">--Choose Consignor--</option>
							<c:forEach items="${cList}" var="cl">
								<option value="${cl.companyId} ">${cl.companyName}</option>
							</c:forEach>
						</select>

					</div>
					<div class="form-group col-md-8">
						<label class="control-label ">Available Vehicle </label> <select
							id="vehicleId" name="vehicleId" class="form-control">
						</select>
					</div>
					<div class="form-group">
						<label class="control-label col-md-6" for="email">Username:</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="username"
								placeholder="Enter User Name">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-6" for="pwd">Password:</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="password"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-8">
							<button type="submit" class="btn btn-info">Proceed</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="../common/footer.jsp"%>


</body>

</html>