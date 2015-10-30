작업목표: 객체 생성(서블릿 객체 생성) 자동화하기

실습1:
1. application-context.properties 파일 생성
  => 서블릿 클래스 정보 등록

2. ProjectServer 클래스 변경
  => 리플렉션 API를 사용하여 객체 자동 생성 및 의존 객체 자동 주입
  
실습2:
1. ProjectServer에서 객체 생성 및 의존 객체 주입 기능을 별도의 클래스로 분리한다.
  => PropertyFileApplicationContext 클래스 정의
  => ProjectServer 클래스 변경

실습3:
1. 프로퍼티 파일 대신 애노테이션을 이용한 객체 관리







