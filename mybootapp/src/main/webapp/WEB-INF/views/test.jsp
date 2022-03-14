<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1> test !</h1>
	<table class="table table-dark table-hover">
      <tr>
         <td>번호</td>
         <td>글쓴이</td>
         <td>제목</td>
         <td>날짜</td>
      </tr>
      <c:forEach var="list" items="${result}" varStatus="status">
      <tr>
         <td>${list.boardNum}</td>
         <td>${list.userId}</td>
         <td>${list.boardTopic}</td>
         <td>${list.rDate}</td>
      </tr>
      </c:forEach>
      <tr>
      
         
         
      </tr>
   </table>

 <nav aria-label="Page navigation example">
 	${pagingParam }
 <ul class="pagination pagination-sm">
	               			
	               				<!-- 2. 이전버튼 활성화 여부 -->
	               				<c:if test="${pagingParam.start != 1 }">
									<a href="/boardList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
								</c:if>
								                        		
                        		<!-- 1. 페이지번호 처리 -->
                        		<c:forEach var="num" begin="${pagingParam.start }" end="${pagingParam.end }">
	                        		<li  class="${pagingParam.nowPage eq num ? 'active' : '' }">
	                        		<a href="list.board?pageNum=${num }&amount=${pagingParam.amount}">${num }</a></li>
                        		</c:forEach>
                        		
                        		<!-- 3. 다음버튼 활성화 여부 -->
                        		<c:if test="${pagingParam.end != paging.lastPage}">
									<a href="/boardList?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
								</c:if>
                    			</ul>
</nav>

</body>
</html>