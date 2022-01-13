<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<link href='https://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet'>
<style>

body {
    font-family: 'Belgrano';font-size: 22px;
}


.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  fo
}

.main {
 background-color: black;
}

.card-body text-center {
  background-color: black;
}
.content {

 background-color: black;

}
.card-body text-center {

background-color: yellow;
}

.card shadow my-1 {
background-color: yellow;

}
.col-sm-3 {
background-color: yellow;
}
</style>

<div class="header_bottom">
	<!-- FlexSlider -->
	<div class="container">
  <img src="images/header3.jpg" alt="Snow" style="width:100%;">
  	<div class="centered"><h1>HELP FARMERS</h1></div>
</div>
	<!-- FlexSlider -->
</div>
<div class="main">

	<div class="content">

		<div class="container p-3">
			<div class="row">
				<c:forEach items="${prods }" var="p" end="3">
					<div class="col-sm-3">
						<div class="card shadow my-1">

							<div class="card-body text-center" >
								<a href="/addtocart/${p.prodid}"> <img
									style="height: 200px;" class="img-thumbnail card-img-top"
									src="${p.pic}" alt="" /></a>
								<h2 class="p-2 font-weight-bold" style="font-size: 14px;">${p.pname}</h2>
								<p style="margin-bottom: 5px;">
									<span>&#8377;${p.saleprice}</span>
								</p>
								<div class="button" style="margin: auto">
									<a href="addtocart/${p.prodid}"
										class="btn btn-danger btn-block"><i class="fa fa-cart"></i>Add
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
<script>
  window.watsonAssistantChatOptions = {
      integrationID: "1d2edd02-1589-431c-94f2-cb89488a9628", // The ID of this integration.
      region: "us-south", // The region your integration is hosted in.
      serviceInstanceID: "3cdf5ab5-52e5-4bf5-a880-b491c16e5c5c", // The ID of your service instance.
      onLoad: function(instance) { instance.render(); }
    };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js"
    document.head.appendChild(t);
  });
</script>
<jsp:include page="cfooter.jsp"></jsp:include>