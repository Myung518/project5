<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ֹ�Ȯ��â</title>
<link rel="stylesheet" href="../../../resources/static/style/petstore.css" type="text/css" />
</head>
<body>
<div align="center">
	<h2>�ֹ�Ȯ��</h2>
	<div class="bg">
		<ul class="align">
			<li><b>����ǰ��</b> : <c:out value="${order.itemName}" /></li>
			<li><b>����</b> : <c:out value="${order.auctionedPrice}" />��</li>
		</ul>
	</div>
	
	<p>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th colspan="2">�������</th>
		</tr>
		<tr>
			<td class="bold">�̸�</td>
			<td><c:out value="${order.userName}" /></td>
		</tr>
		<tr>
			<td class="bold">��ȭ��ȣ</td>
			<td><c:out value="${order.phone}" /></td>
		</tr>
		<tr>
			<td class="bold">�ּ�</td>
			<td><c:out value="${order.destination}" /></td>
		</tr>
		<tr>
			<td class="bold">ī���ȣ</td>
			<td><c:out value="${order.credit}" /></td>
		</tr>	
	</table>
	
	<p>
	<a href="<c:url value='/auction/auctioned_buyer' />"><input type="button" value="����"/></a>
	<a href="<c:url value='/auction/auctioned_receipt' />"><input type="button" value="�����ϱ�"/></a></p>
</div>
</body>
</html>