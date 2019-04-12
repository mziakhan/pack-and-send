<c:if test="${errorMsg != null && errorMsg != ''}">
	<div class="col-md-12 msg-div">
		<div class="alert alert-danger">
			<strong>${errorMsg}.</strong>
		</div>
	</div>
</c:if>
<c:if test="${successMsg != null && successMsg != ''}">
	<div class="col-md-12 msg-div">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">x</span><span class="sr-only">Close</span>
			</button>${successMsg}.
		</div>
	</div>
</c:if>