<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
<h3><font color="red">Error!</font></h3>

<b><c:out value="${message}" default="No further information was provided."/></b>
</body>
</html>