<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<section>
<br>
<div align=center>
<h2>주문서 목록조회 &emsp; </h2>
<form method="post" name="f1">
 <table border=1  width=800>
 <tr align="center">
      <th> idx </th> <th> custno </th>
      <th> baesongbi </th> <th> totalmoney </th>
      <th> getdate </th>
 </tr>
<c:forEach items="${li}"  var="c" >
 <tr> 
      <td align="center">&emsp;${c.idx}</td> 
      <td >&emsp;
       <a href="${path}/orderOne.do?idx=${c.idx}">
          ${c.ocustNo}</a>
      </td>
      <td align="right">
      ${c.baesongbi}</td>
      <td align="center">
      ${c.totalmoney}
      </td> 
      <td >&emsp;<fmt:formatDate value="${c.getDate}" pattern="yyyy-MM-dd" /></td>
 </tr> 
</c:forEach>
</table>
</form>

</div>
<br>

</section>
<c:import url="/include/bottom.jsp" />
<script type="text/javascript">
	function delK(k){
		location.href="/k2/deleteOneCart.do?cartId="+k+"&custNo="+${m.custno};
	}
</script>