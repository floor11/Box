<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Box connection</title>
</head>
<body>
Box connection
<c:out value="${errorMessage}" />
<form action="?" method="POST">
	<input type="text" name="login" />
	<input type="password" name="password" />
	<input type="hidden" name="action" value="connect" />
	<input type="submit" value="login" />
</form>
</body>
</html>