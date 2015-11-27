[주제: JSP 사용법]
1. Template Data와 서블릿 클래스
  - JSP 엔진은 .jsp 파일을 가지고 서블릿 클래스를 자동 생성한다.
  - 자동 생성된 코드는 어디?
    톰캣 임시 작업 폴더/work/ 디렉토리 아래에 있다. 확인할 것!
  - Test01.jsp

2. Scriptlet 태그의 사용
  - JSP 페이지 안에 자바 코드를 넣고 싶을 때
  - Test02.jsp

3. Expression 태그의 사용
  - 계산식의 결과를 출력하고 싶을 때
  - Test03.jsp
  
4. Declaration 태그의 사용
  - 서블릿 클래스에 필드나 메서드를 추가하고 싶을 때
  - Test04.jsp

5. 스크립트릿에서 사용할 클래스를 임포트하기
  - page 지시어의 import 속성을 사용하여 클래스 패키지 정보를 기술한다.  
  - Test05.jsp  
  
6. JSP 내장 변수 (built-in variables) 
  - _jspService() 메서드 안에 공식적으로 선언된 변수.
  - JSP 엔진은 클래스를 자동 생성할 때 반드시 다음 변수를 _jspService() 메서드에 
    선언해야 한다.
    request: HttpServletRequest
    response: HttpServletResponse
    pageContext: PageContext
    session: HttpSession
    application: ServletContext
    config: ServletConfig
    out: JspWriter
    page: Object (서블릿 인스턴스 자신을 가리킴. 즉 this와 같다.)
    error: Exception (오류를 처리하는 페이지라서 선언할 때만 이 변수가 생성된다.)

* whitespace? space(공백), new line, tab    

[JSP 액션 태그 사용법]
<jsp:useBean> 
  - Test06.jsp
  
<jsp:include>, <jsp:forward>     
  - Test07.jsp
  
[JSP Expression Language 사용법]
EL 표기법과 객체 범위
  - Test01.jsp : 보관소에서 데이터를 꺼내는 일반적인 방법
  - Test02.jsp : PageContext.findAttribute() 사용법
  - Test03.jsp : EL 문법을 사용하여 객체 꺼내기
  - Test04.jsp : 맵에 저장된 데이터 꺼내기
  - Test05.jsp : 객체의 프로퍼티 값 꺼내기
  - Test06.jsp : OGNL을 사용하여 계층 구조의 값 꺼내기

  
    
    
    
  
  
  
  
  
    
  
   