<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- 날짜 데이터를 다루는 태그 fmt:parseDate, fmt:formatDate --%>

<%-- 문자열을 Date 객체로 만들기 --%>
<fmt:parseDate value="2015-08-08" pattern="yyyy-MM-dd" 
   scope="page" var="date1"/>
=> ${date1}, 

<fmt:parseDate value="08/09/2015" pattern="MM/dd/yyyy" 
   scope="page" var="date2"/>
=> ${date2},   
   
<%-- 날짜 객체를 문자열로 바꾸기 --%>
<fmt:formatDate value="${date1}" pattern="yyyy-MM-dd"/>,
<fmt:formatDate value="${date2}" pattern="MM/dd/yyyy"/>


   
   
   
   
   
   
   