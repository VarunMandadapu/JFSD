<jsp:include page="cheader.jsp"></jsp:include>
    <div class="card p-2 m-2 shadow">
        <div class="card-body">
            <h5 class="p-2" style="border-bottom: 2px solid orange;">Profile Page</h5>
            <div class="row">
            	<div class="col-sm-6"> 
            	<form method="post">
            	<input type="hidden" name="userid" value="${user.userid }">
            	<table class="table">
					<tr>
						<th>Name</th>
						<th><input type="text" name="fname" value="${user.fname }" class="form-control"></th>
						<th><input type="text" class="form-control" name="lname" value="${user.lname }"></th>
					</tr>
					<tr>
						<th>Gender</th>
						<th colspan="2"><select name="gender" class="form-control">
						<option>Male</option>
						<option>Female</option>
						</select></th>
					</tr>
					<tr>	
						<th>Email Id</th>
						<th colspan="2"><input type="email" readonly name="email" class="form-control" value="${user.email }"></th>
					</tr>
					<tr>	
						<th>Date of Birth</th>
						<th colspan="2"><input type="date" name="dob" value="${user.dob }" class="form-control"></th>
					</tr>
					<tr>	
						<th>City</th>
						<th colspan="2"><input type="text" name="city" class="form-control" value="${user.city }"></th>
					</tr>
					<tr>
						<th colspan="3">
							<button class="btn btn-primary">Update</button>
						</th>
					</tr>
				</table>
				</form>
            	</div>
			</div>
            	</div>
            </div>
			
        </div>
    </div>
<jsp:include page="cfooter.jsp"></jsp:include>