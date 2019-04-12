<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">Pack 'N Send</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${sessionScope.loginUser.userId eq 1 }">
					<li class="nav-item active"><a class="nav-link"
						href="AdminActionServlet?requestUrl=add">Add Book<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="AdminActionServlet?requestUrl=user_list">Registered User</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AdminActionServlet?requestUrl=issue_books">Issue Books</a></li>
				</c:when>
				<c:when test="${sessionScope.loginUser.userId > 1 }">
					<li class="nav-item"><a class="nav-link"
						href="AdminActionServlet?requestUrl=issue_books">Your Books</a></li>
				</c:when>
				<c:when test="${admin!=false && isConsignee!=true && isConsignor!=true}">
<!-- 					<li class="nav-item"><a class="nav-link" -->
<!-- 						href="action?requestUrl=add">Add Company Info </a></li> -->
					<li class="nav-item"><a
						class="nav-link glyphicon glyphicon-log-out"
						href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:when>
				<c:when test="${isConsignor!=false && isConsignee!=true}">
<!-- 					<li class="nav-item"><a class="nav-link" -->
<!-- 						href="#tab2">Add Owned Vehicle </a></li> -->
<!-- 					<li class="nav-item"><a class="nav-link" -->
<!-- 						href="#tab1">Register Driver Details </a></li> -->
				</c:when>
				<c:otherwise>
			
				</c:otherwise>
			</c:choose>
		</ul>
		<!--     <span class="navbar-text"> -->
		<!--       Navbar text with an inline element -->
		<!--     </span> -->
	</div>
</nav>