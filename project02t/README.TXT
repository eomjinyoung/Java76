[주제: 퍼시스턴스 프레임워크 "MyBatis" 적용]
1. mybatis 라이브러리 추가
  => build.gradle 파일에 의존 라이브러리 정보 추가.
  => gradle build... 실행 => .classpath 파일 개정.(mybatis 라이브러리 추가)

2. mybatis 설정 파일 작성
  => java76/pms/dao/mybatis-config.xml 파일 작성

3. SQL 파일 작성
  => java76/pms/dao/xxxDao.xml 파일 작성
  => DAO 당 한 개의 XML 파일

4. mybatis 객체 준비
  => SqlSessionFactory 객체 준비 => ProjectServer 클래스 변경
  => SqlSessionFactory 객체를 AnnotationApplicationContext 객체에 저장한다.
  
5. DAO가 SqlSessionFactory를 사용할 수 있도록 설정.
  => XxxxDao 클래스에 SqlSessionFactory를 저장할 수 있도록 필드(인스턴스 변수)를 추가한다. 
  => 설정 프로퍼티(셋터 메서드)도 추가한다. 프로퍼티명: set/get을 제거하고, 첫 앞파벳 소문자.
     예) getFirstName()/setFirstName() => firstName
     
6. DAO에 있는 기존 메서드를 SqlSessionFactory를 사용하도록 변경한다.
  => SQL Mapper 파일 추가: StudentDao.xml, BoardDao.xml, ProjectDao.xml
  => 목록에 적용
    . SQL 맵퍼 파일에 select SQL 추가 
    . DAO의 selectList() 메서드에 적용
  => 


  
  
  
  
  
  
  
  
     