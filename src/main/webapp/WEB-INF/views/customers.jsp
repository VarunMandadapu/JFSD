<jsp:include page="header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<h5 class="p-2" style="border-bottom: 2px solid green;">Customers List</h5>
<div class="row">
    <div class="col-sm-12">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>User Id</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Gender</th>                    
                    <th>Email Id</th>                    
                    <th>Date of Birth</th>                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users }" var="u">
                    <tr>
                        <td>${u.userid}</td>
                        <td>${u.fname} ${u.lname }</td>
                        <td>${u.pwd}</td>
                        <td>${u.gender}</td>                                         
                        <td>${u.email}</td>                                         
                        <td><fmt:parseDate value='${u.dob}' pattern="yyyy-MM-dd" var="dob" type="date" />
                    <fmt:formatDate
								pattern="dd-MMM-yyyy" value="${dob}" /></td>                                         
                    </tr>
                </c:forEach>
            </tbody>
        </table>        
    </div>    
</div>
<jsp:include page="footer.jsp"></jsp:include>