<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>boardList.jsp</title>
  <jsp:include page="/include/bs5.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
  <h2 class="text-center">게시판 리스트</h2>
  <br/>
  <div class="mb-2"><a href="boardInput" class="btn btn-success">글쓰기</a></div>
  <table class="table table-hover">
    <tr class="table-secondary text-center">
      <th class="p-3">번호</th>
      <th class="p-3">글제목</th>
      <th class="p-3">글쓴이</th>
      <th class="p-3">글쓴날짜</th>
      <th class="p-3">조회수</th>
    </tr>
		<c:forEach var="vo" items="${vos}" varStatus="st">
	    <tr class="text-center">
	      <td>${vo.idx}</td>
	      <td class="text-start"><a href="boardContent?idx=${vo.idx}"  class="text-dark link-primary link-underline-opacity-0 link-underline-opacity-100-hover">${vo.title}</a></td>
	      <td>${vo.name}</td>
	      <td>${vo.wDate}</td>
	      <td>${vo.readNum}</td>
	    </tr>
		</c:forEach>
  </table>
</div>
</body>
</html>
