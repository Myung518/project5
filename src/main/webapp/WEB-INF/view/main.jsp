<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- include_top.jsp�ɺκ� ���� -->
	<table class="top">
		<tr>
			<td><a href="shop/index.do"> <img border="0"
					src="images/artsell_logo_white.jpg" /></a></td>
			<td style="text-align: right"><a href="shop/viewCart.do"> <img
					border="0" name="img_cart" src="images/cart.gif" /></a> <img
				border="0" src="images/separator.gif" /> <a href="/user/logout">
					<button>�α׾ƿ�</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>����������</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>�����Ȳ</button>
			</a></td>
		</tr>
		<tr>
			<td></td>
			<td style="text-align: right"><a href="..">
					<button>�׸� ���</button>
			</a> <img border="0" src="images/separator.gif" />&nbsp; <a href="..">
					<button>�� �׸� ����</button>
			</a></td>
		</tr>
	</table>
	<!-- include_top.jsp�ɺκ� �� -->


	<!-- include_search.jsp�ɺκ� ���� -->
	<div align="center">
		<a href="shop/index.do">ǳ��ȭ</a> <img border="0"
			src="images/separator.gif" /> <a href="shop/index.do">�ι�ȭ</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">����ȭ</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">�߻�ȭ</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">����ȭ</a> <img
			border="0" src="images/separator.gif" />
			<a href="shop/index.do">����ȭ</a> 
	</div>
	<table class="search">
		<tr>
			<td valign="top" width="100%" style="text-align: center">
				<form action="shop/searchProducts.do" method="post">
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

			<td><p>&lt;ǳ��ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/landscape.jpg" /></a></td>
			<td><p>&lt;�ι�ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/figure-painting.jpg" /></a></td>
			<td><p>&lt;����ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/ink-and-wash.jpg" /></a></td>
		</tr>

		<!-- ī�װ� 2��° �� -->
		<tr>
			<td><p>&lt;�߻�ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/abstract.jpg" /></a></td>
			<td><p>&lt;����ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/stillLife.jpg" /></a></td>
			<td><p>&lt;����ȭ&gt;</p> <a href=".."> <img width="130px"
					height="130px" border="0" src="images/animalization.png" /></a></td>
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