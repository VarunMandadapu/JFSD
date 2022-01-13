<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<jsp:include page="cheader.jsp"></jsp:include>

<div class="container-fluid" style="background:  #edfafd">
    <h5 class="text-center my-2 border-bottom text-white p-3 bg-primary">Order Details of No. ${o.id}</h5>
    <p class="float-right p-2">Order Status : <strong>${o.status}</strong> </p>
    <p class="p-2">Customer Name : <strong>${o.customer.fname } ${o.customer.lname }</strong></p>

    <div class="row">
        <div class="col-sm-7">
            <div class='p-3 rounded bg-white'>
                <c:forEach items="${items }" var="item">
	                <div class="border-bottom pb-3 shadow mb-2">
	                    <img class="mr-2 float-left" src="${item.product.pic }" width="90" height="90">
	                    <div class="p-2">
	                        <h5 class="p-1 font-weight-bold">${item.product.pname }</h5>
	                        <h6 class="p-1">Company : ${item.product.company }</h6>
	                        <h6>&#8377; ${item.price}</h6>
	                        <h6 class="float-left p-2">Item Status : ${item.status }</h6>
	                        <h6 class="float-right font-weight-bold">Quantity Ordered : ${item.qty}</h6>
	                    </div>
	
	                    <div class="clearfix"></div>
	                </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-sm-5">
            <div class='rounded bg-white p-2'>
                <h5 class="p-2">Payment Details</h5>
                <table class="table">
                    <tr>
                        <th>MRP Total</th>
                        <th class="text-right font-weight-bold">&#8377; ${o.totalOrderPrice}</th>
                    </tr>
                    <tr>
                        <th>Tax @10%</th>
                        <th class="text-right font-weight-bold">&#8377; ${o.totalOrderPrice * 0.10}</th>
                    </tr>
                    <tr>
                        <th>Net Amount</th>
                        <th class="text-right font-weight-bold">&#8377; ${o.totalOrderPrice+o.totalOrderPrice * 0.10}</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <c:set var="status" value="Pending" />
    <c:choose>
    <c:when test="${o.status eq status }">
    <a onclick="return confirm('Are you sure to cancel this order ?')" 
       href="/cancel/${o.id}" class="btn btn-danger float-right my-2">Cancel Order</a>        
    <div class="clearfix"></div>
    </c:when>
    <c:otherwise>
    <h5 class="text-center p-2">Your order will be delivered to you within 2-3 working days.</h5>
    </c:otherwise>
    </c:choose>
</div>

<jsp:include page="cfooter.jsp"></jsp:include>