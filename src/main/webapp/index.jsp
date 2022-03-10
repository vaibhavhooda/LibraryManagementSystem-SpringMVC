<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome to the Library Management System</h1>
	<br>
	<form action="member" method="get">
		<input type="submit" name="login" value="Member" /><br><br>
	</form>

	<form action="book" method="get">
		<input type="submit" name="book" value="Books" /><br><br>
	</form>
	
	<form action="pub" method="get">
		<input type="submit" name="publisher" value="Publisher" /><br><br>
	</form>
	
	<form action="borrow" method="get">
		<input type="submit" name="borrow" value="Borrow" />
	</form>
	
</body>
</html>
