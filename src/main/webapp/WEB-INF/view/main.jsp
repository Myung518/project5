<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../style/petstore.css" type="text/css" />

</head>
<body>
	<!-- include_top.jsp�ɺκ� ���� -->
	<table class="top">
		<tr>
			<td><a href="<c:url value="/home"/>"> <img border="0"
					src="images/artsell_logo_white.jpg" /></a></td>
			<td style="text-align: right">
			<c:if test="${empty userSession.account}">
					<a href="<c:url value='/user/register'/>">
						<button>ȸ������</button>
					</a>
					</c:if>
					<c:if test="${empty userSession.account}">
					<a href="<c:url value='/user/login'/>">
						<button>�α���</button>
					</a>
					</c:if>
			<c:if
					test="${!empty userSession.account}">
					<a href="<c:url value="/user/logout"/>">
						<button>�α׾ƿ�</button>
					</a>
					<img border="0" src="images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/update"/>">
						<button>ȸ����������</button>
					</a>
						<img border="0" src="images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/delete"/>">
						<button>ȸ��Ż��</button>
					</a>
					<img border="0" src="images/separator.gif" />&nbsp; <a
						href="<c:url value="/user/mypage"/>">
						<button>����������</button>
					</a>
					<img border="0" src="images/separator.gif" />&nbsp; <a
						href="<c:url value="/auction/list"/>">
						<button>�����Ȳ</button>
					</a>
				</c:if></td>
		</tr>
		<tr>
			<td></td>
			<c:if test="${!empty userSession.account}">
				<td style="text-align: right"><a
					href="<c:url value="/myitem/add"/>">
						<button>�׸� ���</button>
				</a> <img border="0" src="images/separator.gif" />&nbsp; <a
					href="<c:url value="/myitem/list"/>">
						<button>�� �׸� ����</button>
				</a></td>
			</c:if>
		</tr>
	</table>
	<!-- include_top.jsp�ɺκ� �� -->


	<!-- include_search.jsp�ɺκ� ���� -->
	<div align="center">
		<a href="<c:url value="/shop/viewCategory"/>">ǳ��ȭ</a> <img border="0"
			src="images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory"/>">�ι�ȭ</a> <img border="0"
			src="images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory"/>">����ȭ</a> <img border="0"
			src="images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory"/>">�߻�ȭ</a> <img border="0"
			src="images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory"/>">����ȭ</a> <img border="0"
			src="images/separator.gif" /> <a
			href="<c:url value="/shop/viewCategory"/>">����ȭ</a>
	</div>
	<table class="search">
		<tr>
			<td valign="top" width="100%" style="text-align: center">
				<form action="<c:url value="/search/item"/>" method="post">
					<select name="job">
						<option value="��ǰ��" selected="selected">��ǰ��</option>
						<option value="ȭ����">ȭ����</option>
					</select> <input name="keyword" size="50" />&nbsp; <input
						src="images/search.gif" type="image" />
				</form>
			</td>
		</tr>
	</table>
	<!-- include_search.jsp�ɺκ� �� -->

	<!-- body�� �ɺκ� ����. -->
	<table class="t1">
		<tr>

			<td><p>&lt;ǳ��ȭ&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=landscape" />">
					<img width="130px" height="130px" border="0"
					src="images/landscape.jpg" />
			</a></td>
			<td><p>&lt;�ι�ȭ&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=figure-painting" />">
					<img width="130px" height="130px" border="0"
					src="images/figure-painting.jpg" />
			</a></td>
			<td><p>&lt;����ȭ&gt;</p> <a
				href="<c:url value="/shop/viewCategory?categoryId=ink-and-wash" />">
					<img width="130px" height="130px" border="0"
					src="images/ink-and-wash.jpg" />
			</a></td>
		</tr>

		<!-- ī�װ� 2��° �� -->
		<tr>
			<td><p>&lt;�߻�ȭ&gt;</p> <a"<c:url value="/shop/viewCategory?categoryId=abstract" />">
					<img width="130px" height="130px" border="0"
					src="images/abstract.jpg" />
			</a></td>
			<td><p>&lt;����ȭ&gt;</p> <a
				href="/shop/viewCategory?categoryId=stillLife"> <img
					width="130px" height="130px" border="0" src="images/stillLife.jpg" /></a></td>
			<td><p>&lt;����ȭ&gt;</p> <a
				href="/shop/viewCategory?categoryId=animalization"> <img
					width="130px" height="130px" border="0"
					src="images/animalization.png" /></a></td>
		</tr>
	</table>
	<!-- body �κ� �� -->


	<!-- include_bottom.jsp�� �κ� ����-->
	<div align="center">
		<table>
			<tr>
				<td><a href="http://www.springframework.org"> <img
						border="0" src="images/spring-logo.png"
						alt="Powered by the Spring Framework" /></a></td>
				<td><a href="http://www.ibatis.com"> <img border="0"
						src="images/mybatis-logo.png" alt="Powered by MyBatis" /></a></td>
			</tr>
		</table>
	</div>
	<!-- include_bottom.jsp�� �κ� ��-->
</body>
</html>