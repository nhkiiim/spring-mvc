<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
  <!--((Member)request.getAttribute("member")).getId()와 같음-->
  <li>id=${member.id}</li>
  <!--JSP에서 제공하는 프로퍼티 접근법-->
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>