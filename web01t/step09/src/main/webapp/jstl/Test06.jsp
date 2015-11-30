<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 조건문 코드를 생성하는 c:if 태그 --%>
<%
pageContext.setAttribute("name", "홍길동");
%>
<c:if test="${not empty name}">
${name}
</c:if>

<c:if test="${empty name2}">
name2 값이 없습니다!
</c:if>

<%-- 조건 테스트의 결과를 보관소에 저장할 수 있다. --%>
<c:if test="${empty name3}" scope="page" var="name3result">
name3 값이 없습니다!
</c:if>

${name3result},

<c:if test="${name3result == true}">
name3의 결과는 true입니다.
</c:if>




