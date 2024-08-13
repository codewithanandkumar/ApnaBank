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
<%String msg=(String)request.getParameter("msg"); %>
<script>
var msg="<%=msg%>"
alert("Your account number :"+msg" is not exist!");
var val=confirm("Do You Want to Create new Account ?");
if(val)
{
location.replace("http://localhost:8083/BankingProject/CreateNewAccount.html");	
}
else
{
location.replace("http://localhost:8083/BankingProject");
}
</script>
</body>
</html>