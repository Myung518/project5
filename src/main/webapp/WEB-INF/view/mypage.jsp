<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="style/petstore.css" type="text/css" />
<!-- 나영 수정1-->                                                 
<title>myPage</title>
</head>
<h1>My Page</h1>
<body bgcolor="white">
	<table class="mypage" border="0" align="center">
		<tr height="100px">
			<td><a href="/auction/list/"><button>경매참여목록</button></a></td>
			<td><a href="/user/update"><button>회원정보 수정</button></a></td>
		</tr>

		<tr height="100px">
			<td><a href="/interesting/list"><button>내 그림 관리</button></a></td>
			<td><a href=".."><button>회원탈퇴</button></a></td>

		</tr>

		<tr height="100px">
			<td><a href=".."><button>찜 목록</button></a></td>
		</tr>
	</table>
</body>
</html>