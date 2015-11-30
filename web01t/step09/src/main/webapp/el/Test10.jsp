<%-- EL 사용법(Expression Language)
--%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- EL 연산자 사용법 --%>
\${10 + 20} = ${10 + 20}
\${10 - 20} = ${10 - 20}
\${10 * 20} = ${10 * 20}
\${10 / 20} = ${10 / 20}
\${10 div 20} = ${10 div 20}
\${10 % 20} = ${10 % 20}
\${10 mod 20} = ${10 mod 20}
---------------------------------
\${true && true} = ${true && true}
\${false && true} = ${false && true}
\${true || true} = ${true || true}
\${false || true} = ${false || true}
\${true and true} = ${true and true}
\${false or true} = ${false or true}
\${!true} = ${!true}
\${not true} = ${not true}
---------------------------------
\${10 < 20} = ${10 < 20}
\${10 lt 20} = ${10 lt 20}
\${10 <= 20} = ${10 <= 20}
\${10 le 20} = ${10 le 20}
\${10 > 20} = ${10 > 20}
\${10 gt 20} = ${10 gt 20}
\${10 >= 20} = ${10 >= 20}
\${10 ge 20} = ${10 ge 20}
\${10 == 20} = ${10 == 20}
\${10 eq 20} = ${10 eq 20}
\${10 != 20} = ${10 != 20}
\${10 ne 20} = ${10 ne 20}
---------------------------------
<%
pageContext.setAttribute("name", "홍길동");
%>
\${empty name} = ${empty name}
\${empty age} = ${empty age}
---------------------------------
\${name == "홍길동" ? "안녕하세요" : "누구세요?"} = ${name == "홍길동" ? "안녕하세요" : "누구세요?"}
\${name == "홍길동2" ? "안녕하세요" : "누구세요?"} = ${name == "홍길동2" ? "안녕하세요" : "누구세요?"}










 