<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.CreateNewAccountBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Balance</title>
<link rel="icon" href="bank.png">
<link rel="stylesheet" href="styles.css">
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
			<span>www.howitpossible.com</span><br>
			<span>www.javatpoint.com</span><br>
			 <span>www.codewithanand.com</span>
		</div>
		<div class="Services" id="newAcforFlex">
		<%CreateNewAccountBean cnab=(CreateNewAccountBean)request.getAttribute("msg"); %>
		
			<h1>Welcome &nbsp;<%=cnab.getUserName() %></h1><br>
			<table>
				<th>Account No</th>
				<th>UserName</th>
				<th>Amount</th>
				<th>Address</th>
				<th>Phone</th>
					<tr>
						<td><%=cnab.getAccNo() %></td>
						<td><%=cnab.getUserName() %></td>
						<td><%=cnab.getAmount()%></td>
						<td><%=cnab.getAddress() %></td>
						<td><%=cnab.getPhno() %></td>
					</tr>
			</table>
		</div>
		
		<div class="Services" id="pngBank">
			<h1>Welcome</h1>
			<img alt="Anand" src="ApnaBank.jpg" width="80%">
			<p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign starting from business
			template, fashion template, media template, Science template, arts template and much more. </p>
		</div>
	</article>

</body>
</html>