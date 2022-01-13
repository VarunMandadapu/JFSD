<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>

<style>
.main {
background-color:black;

}
.content {
background-color:black;


}
</style>
<div class="main">

	<div class="content">

		<div class="container">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-end">
					<c:forEach var="i" begin="1" end="${totalpages }">
						<li class="page-item ${i == current ? 'active' : ''}"><a
							class="page-link" href="/product/${i }">${i }</a></li>
					</c:forEach>
				</ul>
			</nav>
			<div class="row">
				<c:forEach items="${prods }" var="p">
					<div class="col-sm-3">
						<div class="card shadow my-1">

							<div class="card-body text-center">
								<a href="/addtocart/${p.prodid}"> <img
									style="height: 200px;" class="img-thumbnail card-img-top"
									src="${p.pic}" alt="" /></a>
								<h2 class="p-2 font-weight-bold" style="font-size: 14px;">${p.pname}</h2>
								<p style="margin-bottom: 5px;">
									<span>&#8377;${p.saleprice}</span>
								</p>
								<div class="button" style="margin: auto">
									<a href="addtocart/${p.prodid}"
										class="btn btn-success btn-block"><i class="fa fa-cart"></i>Add
										to Cart</a>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<jsp:include page="cfooter.jsp"></jsp:include>