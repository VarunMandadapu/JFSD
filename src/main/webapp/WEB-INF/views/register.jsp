<div class="register_account shadow m-2" style="width:calc(100% - 445px);">
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
