<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="top">
	<tr>
		<td><a href="<c:url value="/home"/>"> <img border="0"
				src="../images/artsell_logo_white.jpg" /></a></td>
		<td style="text-align: right">
			<%-- <c:out value="${userSession.account.userId}" /> --%> <!-- cnrk -->
			<c:if test="${!empty userSession.account}">
				<a href="<c:url value="/user/logout"/>">
					<button>�α׾ƿ�</button>
				</a>
				<img border="0" src="../images/separator.gif" />&nbsp; <a
					href="<c:url value="/user/mypage"/>">
					<button>����������</button>
				</a>
				<img border="0" src="../images/separator.gif" />&nbsp; <a
					href="<c:url value="/auction/list"/>">
					<button>�����Ȳ</button>
				</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<td></td>
		<c:if test="${!empty userSession.account}">
			<td style="text-align: right"><a
				href="<c:url value="/myitem/add"/>">
					<button>�׸� ���</button>
			</a> <img border="0" src="../images/separator.gif" />&nbsp; <a
				href="<c:url value="/myitem/list"/>">
					<button>�� �׸� ����</button>
			</a></td>
		</c:if>
	</tr>
</table>