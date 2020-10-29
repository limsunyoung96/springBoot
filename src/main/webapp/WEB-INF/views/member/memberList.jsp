<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>memberList.jsp</title>
</head>
<body>

	<div class="container">
		<h3>회원 목록</h3>
		
	<!-- START : 검색 폼  --> 

<!-- END : 검색 폼  --> 
<div class="row" style="margin-bottom: 10px;">

		<table class="table table-striped">
			<caption class ="hidden">회원목록 조회</caption>
			<colgroup>
				<col style="width: 7%" />
				<col style="width: 15%" />
				<col />
				<col style="width: 15%" />
				<col style="width: 15%" />
				<col style="width: 15%" />
				<col style="width: 15%" />
			</colgroup>
			<thead>
				<tr>
					<th><input type="checkbox" id="id_member_all_change" /></th>
					<th>ID</th>
					<th>회원명</th>
					<th>HP</th>
					<th>생일</th>
					<th>직업</th>
					<th>마일리지</th>
				</tr>
			</thead>
			<tbody>
			<!-- 아래의 스크립트 코드를 jstl 코드로 변경  -->
				
				<%
					//for(int i = 0; i<members.size(); i++) {
						//MemberVO vo = members.get(i);
				%>
				
				<c:forEach items="${members}" var="vo">
				<tr>
					<td><input type="checkbox" name="memId" value="${vo.memId}" /></td>
					<td>${vo.memId}</td>
					<td><a href="memberView.wow?memId=${vo.memId}">${vo.memName}</a></td>
					<td>${vo.memHp}</td>
					<td>${vo.memBir}</td>
					<td>${vo.memJobNm}</td>
					<td>${vo.memMileage}</td>
				</tr>
				</c:forEach>
				<%
					//}
				%>
			</tbody>
		</table>
	</div>
	<nav class="text-center">
  
</nav>

</body>

</html>










