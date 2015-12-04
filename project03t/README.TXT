[주제: Spring Web MVC 프레임워크 적용]
* 실습
1. Spring WebMVC 라이브러리 추가한다.
  - build.gradle 변경
2. ContextLoaderListener를 스프링 클래스로 대체한다.
  - web.xml 변경
3. 요청 파라미터의 문자집할을 설정하는 필터를 스프링 필터로 대체한다.
  - web.xml 변경
4. 프론트 컨트롤러를 스프링 클래스로 대체한다.
  - web.xml 변경
5. 페이지 컨트롤러를 스프링 규격에 맞추어 변경한다.
  - @RequestMapping을 스프링 애노테이션으로 대체한다.
  - @Component를 @Controller 애노테이션으로 대체한다.
6. 기존의 애노테이션, 리스너, 필터, 서블릿 삭제한다. 
7. 스프링 프론트 컨트롤러(DispatcherServlet)을 위한 설정을 추가한다.
  - 역할을 분담.
    => ContextLoaderListener는 페이지 컨트롤러가 사용할 객체를 준비한다.
       예) DAO, Service, 트랜잭션 등
    => DispatcherServlet은 페이지 컨트롤러와 웹 관련 개체를 준비한다.
       예) 페이지 컨트롤러, 파일 업로드 처리 객체 등
  - /WEB-INF/conf/dispatch-servlet.xml 생성
    => 페이지 컨트롤러 객체를 준비한다.
  - java76/pms/application-context.xml 변경
    => 페이지 컨트롤러 객체를 제외한다.

8. 스프링 멀티파트 데이터 처리
  - dispatch-servlet.xml 파일에 멀티파트 데이터를 처리하는 객체를 등록한다.
  - 페이지 컨트롤러는 멀티파트 파일을 받기 위해 MultipartFile 클래스를 사용해야 한다.  
    
    
    
    
    
    
    
    
     