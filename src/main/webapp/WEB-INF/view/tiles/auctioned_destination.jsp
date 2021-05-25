<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
	<h2>주문확인</h2>
	<div class="bg">
		<ul class="align">
			<li><b>낙찰품목</b> : <c:out value="${order.itemName}" /></li>
			<li><b>가격</b> : <c:out value="${order.auctionedPrice}" />원</li>
		</ul>
	</div>
	
	<p>

	<table class="border">
		<tr bgcolor="#FFD700">
			<th colspan="2">배송정보</th>
		</tr>
		<tr>
			<td class="bold">이름</td>
			<td><c:out value="${order.userName}" /></td>
		</tr>
		<tr>
			<td class="bold">전화번호</td>
			<td><c:out value="${order.phone}" /></td>
		</tr>
		<tr>
			<td class="bold">주소</td>
			<td><c:out value="${order.destination}" /></td>
		</tr>
		<tr>
			<td class="bold">카드번호</td>
			<td><c:out value="${order.credit}" /></td>
		</tr>	
	</table>
	
	<p>
	<a href="<c:url value='/auction/auctioned_buyer' />"><input type="button" value="이전"/></a>
	<a href="<c:url value='/auction/auctioned_receipt' />"><input type="button" value="결제하기"/></a></p>
</div>