<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<div align="center">
		<a href="<c:url value="/shop/viewCategory?categoryId=landscape"/>">ǳ��ȭ</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=figure-painting"/>">�ι�ȭ</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash"/>">����ȭ</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=abstract"/>">�߻�ȭ</a> <img border="0"
			src="../images/separator.gif" /> <a                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			href="<c:url value="/shop/viewCategory?categoryId=stillLife"/>">����ȭ</a> <img border="0"
			src="../images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory?categoryId=animalization"/>">����ȭ</a>
	</div>
	<table class="search">
		<tr>
			<td valign="top" width="100%" style="text-align: center">
				<form action="<c:url value="/search/item"/>" method="post">
					<select name="job">
						<option value="��ǰ��" selected="selected">��ǰ��</option>
						<option value="ȭ����">ȭ����</option>
					</select> <input name="keyword" size="50" />&nbsp; <input
						src="../images/search.gif" type="image" />
				</form>
			</td>
		</tr>
	</table>