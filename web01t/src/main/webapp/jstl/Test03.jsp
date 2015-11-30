<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 변수를 선언하는 태그 
=> 로컬 변수가 아니라 보관소에 저장되는 값이다.
--%>

<c:set var="v1" value="홍길동" scope="page"/>
<c:set var="v2" scope="page">홍길동2</c:set>
<c:set var="v3">홍길동3</c:set>
<c:set var="v4" scope="request">홍길동3</c:set>

v1 = ${pageScope.v1},
v2 = ${pageScope.v2},
v3 = ${pageScope.v3},
v4 = ${pageScope.v4},
v4 = ${requestScope.v4},
v4 = ${v4},




