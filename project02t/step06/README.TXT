[주제: Spring IoC Container 도입]
1. IoC(Inversion of Control) 컨테이너
  => IoC(역제어) => Event 처리, Dependency Injection(의존 객체 주입)
  => IoC 컨테이너 => Bean 컨테이너
     . 객체 관리(생성, 소멸)
     . 의존 객체 주입

2. 실습
1) build.gradle에 의존 라이브러리 등록
2) 기존 IoC 컨테이너(=Bean Container=Instance Container
   =AnnotationApplicationContext)를 스프링 IoC 컨테이너로 교체한다.
3) 스프링 IoC 컨테이너의 설정 파일 생성
  - java76/pms/application-context.xml
4) DAO와 Servlet 클래스에 의존 객체 주입 애노테이션을 추가한다.
  - @Autowired  
5) mybatis-spring 연동 의존 라이브러리 추가
  - apache DB 커넥션 풀 라이브러리도 추가한다. (검색어: apache dbcp)
6) 스프링 설정 파일에 mybatis 객체 준비 추가
7) mybatis-config.xml 삭제






 
   