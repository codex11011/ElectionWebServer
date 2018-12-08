<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../partials/meta.jsp" %>	
<title>Navbar doom</title>
<%@ include file="../partials/header.jsp" %>
<link type="text/css" rel="stylesheet" href="../css/navbar_doom.css">
<link type="text/css" rel="stylesheet" href="../css/candidateForm.css">
<style>
.menu_items a:hover .icon:after {
  border-color: #2A88AD;
}
.menu_items a:active .icon {
  color: #2A88AD;
}
.menu_toggle{
		  background-color: #2A88AD;
}
</style>
<script type="text/javascript" src="../js/HandleSignOut.js"></script>  
</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // Http 1.1
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setHeader("Expires","0"); // Proxies
		
		String domain = (String)session.getAttribute("domain");
		String username = (String) session.getAttribute("username"); 
		String familyName = (String) session.getAttribute("familyname");
		String email = (String) session.getAttribute("email");
		
		if(username == null){
			response.sendRedirect("login.jsp");
		}else{
			username = username.toLowerCase();
			familyName = familyName.toLowerCase();				
		}
		//domain != "lnmiit.ac.in" &&
			
%>
	
<div class="page" style="position:absolute;top:0;left:0;right:0;">
  <span class="menu_toggle">
    <i class="menu_open fa fa-bars fa-lg"></i>
    <i class="menu_close fa fa-times fa-lg"></i>
  </span>
  <ul class="menu_items">
    <li><a href="profile.jsp"><i class="icon fa fa-user fa-2x"></i> Profile</a></li>
    <li><a href="#"><i class="icon fa fa-coffee fa-2x"></i> Coffee</a></li>
    <li><a href="#" onclick="signoutApp()"><i class="icon fa fa-sign-out fa-2x"></i> Logout</a></li>
  </ul>
  <main class="content">
    <div class="content_inner">
    	
		<form autocomplete="off" class="form-style-Bitter" action="../nomineeForm" method="post">
			<h2>Candidate Form<span><% out.println(domain); %></span></h2>
			<div class="section"><span style="position:relative">1</span>Name</div>
				<div class="inner-wrap">
	        		<label for="fname">First Name <br><input id="fname" type="text" name="firstName" value="<% out.println(username); %>" readonly/></label><br>
	        		<label for="faname">Family Name <br><input id="faname" type="text" name="familyName" value="<% out.println(familyName); %>" readonly/></label>
    			</div>
    			<div class="section"><span style="position:relative">2</span>Personal Detail's</div>
				<div class="inner-wrap">                                                      <!-- oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength="25" pattern=".+@lnmiit.ac.in" required title="eg:- 16ucs001@lnmiit.ac.in "  -->
	        		<label for="email">Email<br><input id="email" type="text" name="email" value="<% out.println(email); %>" readonly/></label><br>
	        		<label for="Pnumber">Phone Number <span>+91</span><br><input id="Pnumber" type="number" name="PhoneNumber" oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" pattern="\d*" maxlength="10" required title="10 digits required"/></label><br>
    				<label for="hostel">Hostel<br>
    					<select style="border-radius:20px;" id="hostel" name="hostel" required>
    						<option value="" disabled="disabled" selected="selected">select hostel</option>
    						<option value="BH1">BH 1</option>
    						<option value="BH2">BH 2</option>
    						<option value="BH3">BH 3</option>
    						<option value="GH">GH</option>
    						<option value="Guest House">Guest House</option>
    					</select>
    				</label><br>
    				<label for="roomNum">Room number<br><!--  (S|D|NS|ND|A|B|C|D)*-[0-9]{3}-->
    					<input type="text" maxlength="6"id="roomNum" name="roomNumber" pattern="([a-zA-Z]*-[0-9]{3}|[0-9]{3})" title="format:- ns-703 or A-230 or 102 ">
    				</label>
    			</div>
    			<div class="section"><span style="position:relative">3</span>Academic Info</div>
    			<div class="inner-wrap">
    				<label for="batch">Batch<br>
    				<select style="border-radius:20px;" id="batch" name="batch" required>
    					<option value="" disabled="disabled" selected="selected">Please select your batch</option>
    					<option value="Y18">Y18</option>
					  	<option value="Y17">Y17</option>
					  	<option value="Y16">Y16</option>
					  	<option value="Y15">Y15</option>
    				</select></label><br>
    				<label for="branch">Branch<br>
    				<select style="border-radius:20px;" id="branch" name="branch" required>
    					<option value="" disabled="disabled" selected="selected">Please select your branch</option>
    					<option value="CSE">CSE</option>
					  	<option value="CCE">CCE</option>
					  	<option value="ECE">ECE</option>
					  	<option value="ME">ME</option>
					  	<option value="MME">MME</option>
    				</select></label><br>
    				<label for="cgpa">CGPA &nbsp;(current)<br><input id="cgpa" name="cgpa" type="number" step="any" max="10" min="0" required>
    				</label>
    				</div>
    			
	    	<div class="section"><span style="position:relative">4</span>Other Info</div>
	    	<div class="inner-wrap">
	    		<label>Position<br>
	    		<select style="border-radius:20px;" id="position" name="position" required>
    					<option value="" disabled="disabled" selected="selected">Please select position you are applying for</option>
    					<option value="President">President</option>
					  	<option value="Vice-President">Vice-President</option>
					  	<option value="GSEC-Sports">GSEC-Sports</option>
					  	<option value="GSEC-Science and Tech.">GSEC-Science and Tech.</option>
					  	<option value="GSEC-Cultural">GSEC-Cultural</option>
    				</select>
    			</label><br>	
	    	
	    		
	    	</div>
	    	
	    	<div class="innder-wrap">
	    		<input id="submit" type="submit" value="Submit">		
	    	</div>		
		</form>
	
    </div>
  </main>
</div>

<%@ include file="../partials/footer.jsp" %>	
<script type="text/javascript" src="../js/navbar_doom.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	  
	
	$('#cgpa').on('change',function(){
		if(parseInt($(this).val()) > parseInt($(this).attr('max')))
		{ console.log('worked');
			 $(this).val('');
		}
	});
	
	$('#Pnumber').on('change',function(){
		if(parseInt($(this).val().length) < parseInt($(this).attr('maxlength')))
		{ console.log('worked');
			 $(this).val('');
		}
	});
	
    $('#dropdownList').on('change',function(){
        //var optionValue = $(this).val();
        //var optionText = $('#dropdownList option[value="'+optionValue+'"]').text();
        var optionText = $("#dropdownList option:selected").text();
        alert("Selected Option Text: "+optionText);
    });
    
   
});
</script>
</body>
</html>