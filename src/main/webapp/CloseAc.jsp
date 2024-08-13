<%@page import="Test.CreateNewAccountBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Closed Accno</title>
<link rel="stylesheet" href="styles.css">
<link rel="icon" href="bank.png">
</head>
<body>
<div id="hero">
		<div class="hero-cont">
		<img alt="bankLogo" src="bank.png">
		</div>
		<div class="hero-cont">
		<h1>APNA-BANK</h1>
		<span>Extra-ordinary Service</span>
		</div>
		<div class="hero-cont">
		<img alt="card" src="atmcard.png" >
		</div>
</div>
<header>
		<ul>
		    <a href="../BankingProject"><li>HOME</li></a>
			<a href="CreateNewAccount.html"><li>NEW ACCOUNT</li></a>
			<a href="CheckBalance.html"><li>BALANCE</li></a>
			<a href="DepositForm.html"><li>DEPOSIT</li></a>
			<a href="WithdrawForm.html"><li>WITHDRAW</li></a>
			<a href="Transfer.html"><li>TRNASFER</li></a>
			<a href="CloseAc.html"><li>CLOSE A/C</li></a>
			<a href="AboutUs.html"><li>ABOUT US</li></a>
		</ul>
	</header>

	<article class="content">
		<div class="Services" id="contForService">
			<h1>Services</h1>
			<span><a href="www.howitpossible.com">www.howitpossible.com</a></span><br>
			<span><a href="www.howitpossible.com">www.javatpoint.com</a></span><br>
			 <span><a href="www.javatpoint.com">www.codewithanand.com</a></span>
		</div>
		<div class="Services" id="newAcforFlex">
		<%CreateNewAccountBean cnab=(CreateNewAccountBean)request.getAttribute("msg"); %>
			<h1>Welcome <%=cnab.getUserName() %> your account '<span style="color:red;"><%=cnab.getAccNo() %>'</span>has been closed now.</h1>
		</div>
		
		<div class="Services" id="pngBank">
			<h1>Welcome <%=cnab.getUserName() %> Your account number '<%=cnab.getAccNo() %>' has closed</h1>
			<img alt="Anand" src="ApnaBank.jpg" width="80%">
			<p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign starting from business
			template, fashion template, media template, Science template, arts template and much more. </p>
		</div>
	</article>
	<script type="text/javascript">
	function validation()  
    {  
        var acno=document.newAcFrm.acno.value;  
        var username=document.newAcFrm.username.value;
        var password=document.newAcFrm.password.value;  
        
        if(acno.length=="" && password.length=="" && username.length=="")
        	{
        	alert("All fields are empty");
        	return false;
        	}
        if(acno.length=="")
    	{
    	alert("AccountNo field Empty Appear!!");
    	document.getElementById("acno").focus();
    	return false;
    	}
       if(isNaN(acno))
    	   {
    	   alert("please enter numeric value");
    	   document.getElementById("acno").focus();
    	   return false;
    	   }
        if(username.length=="")
        	{
        	alert("UserName field Empty Appear!!");
        	document.getElementById("username").focus();
        	return false;
        	}
        if(password.length=="")
        	{
        	alert("Password filed Empty!!");
        	document.getElementById("password").focus();
        	return false;
        	}        
    }
</script>  
</body>
</html>