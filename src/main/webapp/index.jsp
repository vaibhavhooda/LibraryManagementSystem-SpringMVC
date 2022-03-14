<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/main.js" />"></script>
</head>
<body>
	<h1>1. Test CSS</h1>

	<h2>2. Test JS</h2>
	<div id="msg"></div>
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
