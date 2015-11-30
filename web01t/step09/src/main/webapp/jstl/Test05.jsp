<%-- JSTL(JSP Standard Tag Library) 사용법 --%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- c:remove를 이용하여 보관소에 저장된 값 지우기
--%>

<jsp:useBean id="board" class="vo.Board" scope="page"/>
no: ${board.no},
title: ${board.title},
views: ${board.views},
-------------------------------
<c:set target="${board}" property="no">100</c:set>
<c:set target="${board}" property="title">오호라.. 제목이네..</c:set>
<c:set target="${board}" property="views">16</c:set>
no: ${board.no},
title: ${board.title},
views: ${board.views},
-------------------------------
<c:remove var="board" scope="page"/>
no: ${board.no},
title: ${board.title},
views: ${board.views},
-------------------------------


















