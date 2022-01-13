<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Farmers Friend</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<link href="/css/menu.css" rel="stylesheet" type="text/css" media="all" />
	<link href="/css/all.css" rel="stylesheet" type="text/css" />
	<link href="/css/flexslider.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="/css/style.css">
	<link href="/css/shop.css" rel="stylesheet" type="text/css" />
	<script src="/js/jquery.min.js"></script>
	<script src="/js/script.js" type="text/javascript"></script>
	<link rel="icon" href="/images/logo.jpg"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<style>
.body {

color : black
}
.h_menu
{

background-color : black;


}
.header {

background-color : black;
h5: white;
}
.text-center float-right p-3 font-weight-bold {

color : white;

}
.container-fluid {

background-color : black;

}
.menu list-unstyled {

background-color: white;
}
.mobile-menu{
background-color: white;

}
.header_top position-reflexive {
background-color: white;

}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

li a {
  display: block;
  width: px;
  background-color: #dddddd;
}
</style>
<body>
	<div class="container-fluid">
		<div class="header">
			<div class="header_top position-reflexive">
			<c:if test="${userid ne null }">
				<h5 class="text-center float-right p-3 font-weight-bold">Welcome ! ${uname }</h5>
			</c:if>
			<div class="position-absolute" style="top:20px;left:40%;">
		
			</div>
			<div class="position-absolute w-100 font-weight-bold" style="top:60px">
				<jsp:include page="msg.jsp"></jsp:include>
			</div>
						
				<div class="logo">
					<a href="/"><img style="width: 180px; height: 100px;"
						src="/images/logo.jpg" alt="" /></a>
				</div>
				<div class="clear"></div>
				
			</div>
			
		</div>

		<div class="conatiner_fluid">
			<a id="touch-menu" class="computer-menu" href="#">Menu</a>
			<nav>
				<ul class="menu list-unstyled">
					<li><a href="/">Home</a></li>
					<li><a href="/product">Products</a></li>
					<li class="activate"><a href="#">Categories</a>
						<ul class="sub-menu list-unstyled sub-menu2">
							<c:forEach items="${cats }" var="cat">
							<li style="width: 190px;"><a href="/cats/${cat.catid}">
									${cat.catname}</a></li>
							</c:forEach>
						</ul></li>
						<c:choose>
					<c:when test="${ sessionScope.userid ne null }">
					<li class="activate float-right" style="width:190px;">
					<a href="#" class="d-block w-100">Hi! ${sessionScope.uname }</a>
					<ul class="sub-menu list-unstyled sub-menu2">
					<li style="width: 190px;"><a href="/profile">Profile</a></li>
					<li style="width: 190px;"><a href="/cchangepwd">Change Password</a></li>
					<li style="width: 190px;"><a href="/logout">Logout</a></li>
					</ul>
					</li>
					<li class="float-right";style="color : black";><a href="/cart">Cart 
					<c:if test="${cqty > 0 }">
					<i class="badge badge-warning">${cqty}</i></c:if>
							</a></li>
					<li class="float-right"><a href="/history">History</a></li>
															
					</c:when>
					<c:otherwise>
					<li class="float-top-top-left"><a href="/login">Sign In and up</a></li>
					</c:otherwise>
					</c:choose>
					<div class="clear"></div>
				</ul>
			</nav>

		</div>