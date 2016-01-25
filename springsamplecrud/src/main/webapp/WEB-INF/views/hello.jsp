<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hi.....</title>
</head>
<body>
hi...........!!!!
name :<%= session.getAttribute("name")%>
name :${name}
<c:out value="${name}"></c:out>
password: <%= request.getAttribute("password") %>
password (using el): ${password}
<a href="${pageContext.request.contextPath}"/hello>hello</a>
</body>
</html>