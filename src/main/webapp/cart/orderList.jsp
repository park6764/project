<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<section>
<br>
<div align=center>
<h2>전체 주문 목록조회 &emsp; </h2>

 <form method="post"  name="f1"  >

 <table border=1  width=800>
 <tr align="center">
      <th> 순번 </th>
      <th> 구매자코드   </th> <th> 배송비  </th>
      <th> 주문금액  </th> <th> 날짜 </th>
 </tr>
<c:forEach items="${li}"  var="c" >

 <tr> 
    <td align="center" >
     <a href=${path}/orderOne.do?idx=${c.idx}>
       ${c.idx}
     </a>
    </td>
    <td align="center" >${c.custnum}</td>
    <td align="center" >${c.baesongbi}</td>
    <td align="center" >${c.totalmoney}</td>
    <td align="center" >
      <fmt:formatDate value="${c.getDate}" pattern="yyyy-MM-dd"/>
    </td>
   
  </tr>

</c:forEach>
 
</table>
</form>
</div>
<br>

</section>




<c:import url="/include/bottom.jsp" />