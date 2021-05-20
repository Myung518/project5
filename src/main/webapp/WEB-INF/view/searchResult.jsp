<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>searchResult</title>
</head>
<body>
<div align="center">
	<h2>��ǰ �˻�</h2>
	<p>
	<c:if test="${!empty categoryName}"><b><c:out value="${categoryName}" /></b>&nbsp;ī�װ� �� �˻� ���</c:if>
	<form action="<c:url value="/search/item" />" method="post">
		<select name="artist">
			<option value="all" selected>all</option>
			<c:forEach var="artist" items="${artistList}">
				<option value="${artist}"><c:out value="${artist}" /></option> <!-- ��ġ�� -->
			</c:forEach>
		</select>
		<input type="hidden" name="search" value="true"/>
	    <input type="search" name="keyword" />&nbsp;
	    <input src="/images/search.png" type="image" />
	</form>
</div>

<div align="center">
	<%-- <c:if test="${categoryId}"><c:out value="${categoryId }</c:if> --%>
	<p>�� <strong><c:out value="${total}" /></strong> ���� ��ǰ�� �˻��Ǿ����ϴ�.</p> <!-- ��ġ�� -->
	<table>
		<th>ī�װ�</th>
		<th>��ǰ</th>
		<th>����</th>
		<th>ȭ��</th>
		<c:forEach var="item" items="${itemList.pageList}">
		<tr>
			<td>
				<a href="<c:url value="/shop/viewCategory">
					<c:param name="categoryId" value="${item.categoryId}" /></c:url>">
					<c:out value="${item.categoryId}" />
				</a>
			</td> <!-- ī�װ� �̸����� �ٲٱ� -->
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
					<img src="<c:out value="${item.picture}" />" />
				</a>
			</td>
			<td>
				<a href="<c:url value="/shop/viewItem">
					<c:param name="itemId" value="${item.itemId}" /></c:url>">
						<c:out value="${item.itemName}" />
				</a>
			</td>
			<td>
				<a href="<c:url value="/search/item">
					<c:param name="artist" value="${item.artist}" /></c:url>">
						<c:out value="${item.artist}" />
				</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
				<p>
				<c:if test="${!itemList.firstPage}">
					<a href="<c:url value="/search/item">
						<c:param name="page" value="previous" /></c:url>">
				   			<B>&lt;&lt; Prev</B></a>
				</c:if>
				<c:if test="${!itemList.lastPage}">
					<a href="<c:url value="/search/item">
						<c:param name="page" value="next" /></c:url>">
				   			<B>Next &gt;&gt;</B></a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>

<!-- �߰��ϸ� ���� �͵�: ���ı��, �α�˻��� ��� -->