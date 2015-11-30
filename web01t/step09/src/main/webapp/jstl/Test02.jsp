<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 출력문을 만드는 태그 - c:out --%>
<c:out value="출력할 값"></c:out>,
<c:out value="출력할 값"/>,
<c:out value="출력할 값1">출력할 값2</c:out>,

<%-- 출력할 값이 null이면 기본 값을 출력한다. --%>
<c:out value="${message}" default="기본 값"/>,
<c:out value="${message}">기본 값</c:out>,
<c:out value="${null}">기본 값</c:out>,







