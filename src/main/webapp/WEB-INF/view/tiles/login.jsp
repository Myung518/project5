<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center" class="loginD">
		<form action='<c:url value="/user/login" />' method="POST">
			<c:if test="${!empty signonForwardAction}">
      		<input type="hidden" name="forwardAction"
        		value='<c:url value="${signonForwardAction}"/>' />
   			</c:if>
			<div id="leftD">
				<input name="pic" type="image" src="../resources/static/images/t1.jpg" width="650px" height="450px">
			</div>
			<div id="rightD" >
				<table>
					<tr>
						<td colspan="2">Please enter your ID and Password. <br />&nbsp;</td>
					</tr>
					<tr>
						<td>ID:</td>
						<td><input type="text" name="userId" size="20" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" size="20" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>
						<button type="submit" name="update">�α���</button>&nbsp
							<a href="<c:url value='/user/register'/>">
						<button type="button" name="button">ȸ������</button>
						</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>