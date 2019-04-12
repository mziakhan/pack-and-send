<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<style>
.dropdown-menu {
    width: 30px !important;
    height: 10px !important;
}
</style>
<div class="panel panel-default border">

	<div class="panel-heading">
		<h3 class="panel-title">Services</h3>
	</div>


	<div class="container">
		<h5>Use Services as Consignor or Consignee</h5>
	</div>

	<div id="exTab2">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="#tab1" data-toggle="tab">Consignee</a></li>
			<li><a class="nav-link" href="#tab2" data-toggle="tab">Consignor</a></li>
		</ul>


		<div class="tab-content ">
			<div class="tab-pane active" id="tab1">
				<%@include file="../consignee/cas-consignee.jsp"%>
			</div>
			<div class="tab-pane" id="tab2">
				<%@include file="../consignor/pas-consignor.jsp"%>
			</div>
		</div>
	</div>


</div>
<script>
	var oldURL = [ #tab1 ]
	var index = 0;
	var newURL = oldURL;
	index = oldURL.indexOf('?');
	if (index == -1) {
		index = oldURL.indexOf('#');
	}
	if (index != -1) {
		newURL = oldURL.substring(0, index);
	}
</script>