<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���â</title>
<link rel="stylesheet" href="../../../resources/static/style/petstore.css" type="text/css" />
</head>
<body>
<div align="center">
	<h2>��ǰ�̸� : �عٶ��</h2>
	<p>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th>ȸ��ID</th>
			<th>��Ű���</th>
		</tr>
		<tr>
			<td class="bold">��ä��</td>
			<td>${}����</td>
		</tr>
		<tr>
			<td class="bold">�ݺ���</td>
			<td>�̿�</td>
		</tr>
	</table>
	<p>
	������� : <input type="text" /> 
	<a href="<c:url value='/auction/bid' />"><input type="button" value="Ȯ��"/></a>
</div>
</body>
</html>