<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>paintingDetail</title>
</head>
<body>
<div align="center">
	<h2>��ǰ ����</h2>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td><c:out value="${item.itemName}" /></td>
		</tr>
		<tr>
			<td>ī�װ�</td>
			<td><c:out value="${item.categoryId}" /></td> <!-- ī�װ� �̸����� �ٲٱ� -->
		</tr>
		<tr>
			<td>���� �ְ�</td>
			<td><c:out value="${item.bestPrice}" /></td>
		</tr>
		<tr>
			<td>ȭ��</td>
			<td><c:out value="${item.artist}" /></td>
		</tr>
		<tr>
			<td>���� ����</td>
			<td>~<c:out value="${item.deadline}" /></td>
		</tr>
		<tr>
			<td colspan="2"><img src="${item.picture}" /></td>
		</tr>
		<tr>
			<td colspan="2" width="40" height="8"><c:out value="${item.description}" />�׸� ����</td>
		</tr>
	</table>
	<a href="<c:url value="/auction/info" />">��� ����</a>
	<c:if test="(���� ��Ͽ� ������)">
		<a href="<c:url value="/interesting/add" />"> <!-- ��ġ�� -->
			<img src="../../static/images/iconmonstr-heart-thin-32.png" />
		</a>
	</c:if>
	<c:if test="(���� ��Ͽ� ������)">
		<a href="<c:url value="/interesting/delete" />"> <!-- ��ġ�� -->
			<img src="../../static/images/iconmonstr-favorite-3-32.png" />
		</a>
	</c:if>
</div>
</body>
</html>