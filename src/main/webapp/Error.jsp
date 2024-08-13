<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<%
String msg=(String)request.getAttribute("msg");
%>
<script type="text/javascript">
var msg="<%=msg%>"
alert(msg);
var val=confirm("Do You Want to Create new Account ?");
if(val)
{
location.replace("http://localhost:8083/BankingProject/CreateNewAccount.html");	
}
else
{
location.replace("http://localhost:8083/BankingProject/CheckBalance.html");
}
</script>
</body>
</html>