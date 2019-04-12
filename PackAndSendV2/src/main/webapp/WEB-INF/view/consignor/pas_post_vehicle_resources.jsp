<c:if test="${successMsg1!=null}">
	<%-- 			<div class="alert alert-success" id="msgAlert">${successMsg1}</div> --%>
	<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${successMsg1}</strong>
	</div>
</c:if>
<c:if test="${errorMsg1!=null}">
	<%-- 			<div class="alert alert-danger" id="msgAlert">${errorMsg1}</div> --%>
	<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${errorMsg1}</strong>
	</div>
</c:if>
<div class="panel panel-default">
	<div class="panel-body">
		<form action="./saveVehicleDetail" method="post" commandName="command1">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label class="control-label ">Select Consignor </label> <select
						id="companyId" name="companyId" class="form-control">
						<option value="">--Choose Consignor--</option>
						<c:forEach items="${cList}" var="cl">
							<option value="${cl.companyId} ">${cl.companyName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="clearfix"></div>
				<div class="form-group col-md-6">
					<label>Type</label> <input type="text" class="form-control"
						id="vehicleType" name="vehicleType" placeholder="Vehicle type">
				</div>
				<div class="form-group col-md-6">
					<label>Make</label> <input type="text" class="form-control"
						id="make" name="make" placeholder="Mitsubhishi">
				</div>
				<div class="form-group col-md-6">
					<label>Model</label> <input type="text" class="form-control"
						id="model" name="model"
						placeholder="Container/Medium Van etc.">
				</div>
				<div class="form-group col-md-6">
					<label>Registration No</label> <input type="text"
						class="form-control" id="regNo" name="regNo"
						placeholder="5524879563">
				</div>
				<div class="form-group col-md-6">
					<label>Vehicle Number</label> <input type="text"
						class="form-control" id="vehicleNumber" name="vehicleNumber"
						placeholder="MP04 CJ 5433">
				</div>
				<div class="form-group col-md-6">
					<label>Manufacturing Date</label> <input type="text"
						class="form-control" id=mfgDateStr name="mfgDateStr"
						placeholder="12-05-2001">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</div>
