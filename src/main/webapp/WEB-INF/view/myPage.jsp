<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!--  -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="style/petstore.css" type="text/css" />
<!-- ���� ����1-->                                                 
<title>myPage</title>
</head>
<h1>My Page</h1>
<body bgcolor="white">
	<table class="mypage" border="0" align="center">
		<tr height="100px">
			<td><a href="<c:url value="/auction/list"/>"><button>����������</button></a></td>
			<td><a href="<c:url value="/user/update"/>"><button>ȸ������ ����</button></a></td>
		</tr>

		<tr height="100px">
			<td><a href="<c:url value="/myitem/list"/>"><button>�� �׸� ����</button></a></td>
			<td><a href="<c:url value="/user/delete"/>"><button>ȸ��Ż��</button></a></td>

		</tr>

		<tr height="100px">
			<td><a href="<c:url value="/interesting/list"/>"><button>�� ���</button></a></td>
		</tr>
	</table>
</body>
</html>