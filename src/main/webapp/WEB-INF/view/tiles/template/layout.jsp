<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="max-age=0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="../style/petstore.css" type="text/css" />

</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="nav" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>