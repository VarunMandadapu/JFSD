<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="cheader.jsp"></jsp:include>
<style>
.register_account label{
	display:inline-block;
	width:140px;
	text-align:left;
}
.form span{
display:block;
text-align:right;
}
.button {
  position: relative;
  background-color: #4CAF50;
  border: none;
  font-size: 28px;
  color: #FFFFFF;
  padding: 20px;
  width: 200px;
  text-align: center;
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

.button:after {
  content: "";
  background: #f1f1f1;
  display: block;
  position: absolute;
  padding-top: 300%;
  padding-left: 350%;
  margin-left: -20px !important;
  margin-top: -120%;
  opacity: 0;
  transition: all 0.8s
}
.button:active:after {
  padding: 0;
  margin: 0;
  opacity: 1;
  transition: 0s
}
.form{
  background-color: red;
  padding: 20px;
  width: 200px;

}

.main {
background-color : black;
}
.register_account shadow m-2 {

background-color : black;

}
.login_panel shadow m-2
{

background-color : red;

}
.row {

background-color : red;

}

.content text-center {

 background-color : red;
 
}

.col-sm-10 mx-auto {
 
 background-color : red;
 

}

</style>

<div class="main">
	<div class="row">
	<div class="col-sm-10 mx-auto">
	    <div class="content text-center">
	        <div class="login_panel shadow m-2" style="width: 1000px; background-color : red;">
	            <h3>Users</h3>
	            <p>Sign in</p>
	            <form method="post" autocomplete="off">
	                <input name="userid" type="text" required placeholder="User ID">
	                <input name="pwd" type="password" required placeholder="Password">                
	                <div class="button">
	                	<div><button class="grey">Sign In</button></div>
	          </div>
	                <jsp:include page="msg.jsp"></jsp:include>
	            </form>
   		  </div>
        <div class="register_account shadow m-2" style=" width:1000px; background-color : red;">
            <img src="/images/logo.jpg" class="img-thumbnail float-right" style="width:200px;">
            <h3>Register New Account</h3>
            <sf:form autocomplete="off" modelAttribute="customer" action="/register" method="post">
                <table>
                    <tbody>
	                <tr>
	                    <td>
	                        <div class="form">
	                        <sf:label path="fname">First Name </sf:label>
	                        <sf:input path="fname" placeholder="First Name"/><br>
	                        <sf:errors path="fname" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="lname">Last Name </sf:label>
	                        <sf:input path="lname" placeholder="Lasst Name"/><br>
	                        <sf:errors path="lname" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="userid">User ID </sf:label>
	                        <sf:input path="userid" placeholder="User ID"/><br>
	                        <sf:errors path="userid" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="dob">Date of Birth </sf:label>
	                        <sf:input path="dob" type="date" /><br>
	                        <sf:errors path="dob" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="gender">Gender </sf:label>
	                        <sf:select path="gender">
	                        	<sf:option value="">-- Select Gender --</sf:option>
	                        	<sf:options items="${genders }"/> 
	                        </sf:select><br>
	                        <sf:errors path="gender" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="city">City</sf:label>
	                        <sf:input path="city" placeholder="City"/><br>
	                        <sf:errors path="city" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="email">Email ID </sf:label>                              
	                        <sf:input path="email" placeholder="Email Id"/><br>
	                        <sf:errors path="email" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="userid">Password </sf:label>                                                    
	                        <sf:password path="pwd" placeholder="Password"/><br>
	                        <sf:errors path="pwd" cssStyle="color:red"></sf:errors>
	                        
	                        <sf:label path="cpwd">Confirm Password </sf:label>                                                    
	                        <sf:password path="cpwd" placeholder="Confirm Password"/><br>
	                        <sf:errors path="cpwd" cssStyle="color:red"></sf:errors>
	                    </td>                            
	                </tr> 
                    </tbody></table> 
                <div class="button"><div><button class="danger">Create Account</button></div></div>
                <div class="clear"></div>
                <c:if test="${rmsg }">
                	<div class="alert text-danger text-center">
                		${rmsg}
                	</div>
                </c:if>
            </sf:form>
        </div>  	
        <div class="clear"></div>
    </div>
</div>
</div>
</div>
<jsp:include page="cfooter.jsp"></jsp:include>