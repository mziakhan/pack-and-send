
<c:if test="${successMsg2!=null}">
	<%-- 			<div class="alert alert-success" id="msgAlert">${successMsg2}</div> --%>
	<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${successMsg2}</strong>
	</div>
</c:if>
<c:if test="${errorMsg2!=null}">
	<%-- 			<div class="alert alert-danger" id="msgAlert">${errorMsg2}</div> --%>
	<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${errorMsg2}</strong>
	</div>
</c:if>
<div class="panel panel-default">
	<div class="panel-body">
		<form action="./saveDriverDetail" method="post" commandName="command2">
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
					<label>Name</label> <input type="text" class="form-control"
						id="name" name="name" placeholder="Driver Name">
				</div>
				<div class="form-group col-md-6">
					<label>Contact No</label> <input type="text" class="form-control"
						id="contactNo" name="contactNo" placeholder="9988551168">
				</div>
				<div class="form-group col-md-6">
					<label>License No</label> <input type="text" class="form-control"
						id="licenseNo" name="licenseNo" placeholder="MH-14-2011-0062821">
				</div>

			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</div>
