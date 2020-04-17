<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	$(document).ready(function () {
		$.validator.addMethod('capitals', function(thing){
			return thing.match(/[A-Z]/);
		});
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true,
					minlength: 15,
					capitals: true,
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				password: {
					minlength: "Password too short, make it at least 15 characters",
					capitals: "Field must contain a capital letter",
				},
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>

<c:url var="formAction" value="/users" />
<form:form method="POST" action="${formAction}" modelAttribute="user">
<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
<%--
	HARD CODED ROLE VALUE PASSES TO DB
<input type="hidden" name="role" value="3"/>  --%>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
		<div class="form-group">
				<label for="email">Email Address: </label>
				<input type="text" id="email" name="email" placeHolder="youremail@yours.you" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
	<%-- Error when passed as dropdown. Tried multiple path names. hardcode on line 44
	works --%>		
	  	<div class="form-group">
				<label for="role">Role: </label>
				<form:select name="role" path="role">
				<option value="3">Organizer</option>
				<option value="2">Team Captain</option>
				<option value="1">Player</option>
				<option	value="1">Fan</option>                                 
			</form:select>
			</div>
			<button type="submit" class="btn btn-success">Create User</button>
		</div>
		
		<div class="col-sm-4"></div>
	</div>
</form:form>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />