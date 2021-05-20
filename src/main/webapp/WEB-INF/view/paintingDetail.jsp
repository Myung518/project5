<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h2>��ǰ ����</h2>
	<table>
		<tr>
			<td>��ǰ��</td>
			<td th:text="${item.itemName}">����</td>
		</tr>
		<tr>
			<td>ī�װ�</td>
			<td th:text="${item.categoryId}">ī�װ�</td> <!-- ī�װ� �̸����� �ٲٱ� -->
		</tr>
		<tr>
			<td>���� �ְ�</td>
			<td th:text="${item.bestPrice}">�ְ�</td>
		</tr>
		<tr>
			<td>ȭ��</td>
			<td th:text="${item.artist}">ȭ��</td>
		</tr>
		<tr>
			<td>���� ����</td>
			<td th:text="${item.deadline}">��������</td>
		</tr>
		<tr>
			<td colspan="2"><img src="${item.picture}" /></td>
		</tr>
		<tr>
			<td colspan="2" width="40" height="8" th:text="${item.description}">�׸� ����</td>
		</tr>
	</table>
	<a href="" th:href="@{/auction/info}">��� ����</a>
	<a href="" th:unless="(���� ��Ͽ� ������)" th:href="@{/interesting/add}"> <!-- ��ġ�� -->
		<img src="../../static/images/iconmonstr-heart-thin-32.png" />
	</a>
	<a href="" th:if="(���� ��Ͽ� ������)" th:href="@{/interesting/delete}"> <!-- ��ġ�� -->
		<img src="../../static/images/iconmonstr-favorite-3-32.png" />
	</a>
</div>
</body>
</html>