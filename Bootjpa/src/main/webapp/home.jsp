<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ADD USER <br><br>
<form action="addAlien">
<input type="text" name="aid"/><br><br>
<input type="text" name="aname"/><br><br>
<input type="text" name="tech"/><br><br>
<input type="submit"><br><br><br>
</form>
GET USER <br><br>
<form action="getAlien">
<input type="text" name="aid"/><br><br>

<input type="submit"><br><br><br><br>
</form>

DELETE USER <br><br>
<form action="deleteAlien">
<input type="text" name="aid"/><br><br>

<input type="submit"><br>
</form>
</body>
</html>