<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/include/top.jsp" />

<section>
	<br>
	<div align=center>
		<h2>방명록 보기 (rows: ${totalCount})</h2>

		<form method="post" name="f1">

			<table border=1 width=800>
				<tr align="center">
					<th>rownum</th>
					<th>rnum</th>
					<th>순번</th>
					<th>내용</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
				<c:forEach items="${li}" var="c">
					<tr>
						<td align="center">${c.rownum}</td>
						<td align="center">${c.rnum}</td>
						<td align="center">${c.idx}</td>
						<td align="center">${c.title}</td>
						<td align="center">${c.writer}</td>
						<td align="center">
							<c:set var="textVal" value="${c.dateStr}"/>
							${fn:substring(textVal, 0, 10)}
						</td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>
	<br>

</section>

<c:import url="/include/bottom.jsp" />