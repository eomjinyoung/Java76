[주제: Gradle 프로젝트 만들기]
1. 일반 프로젝트 생성

2. 이클립스 프로젝트 설정 파일(.project) 변경
  => gradle 네이처 정보 추가.
  <natures>
    <nature>org.springsource.ide.eclipse.gradle.core.nature</nature>
  </natures>
  
3. 프로젝트 관련 폴더 생성
  => src              - 자바 소스 파일 관리
    => main           - 자바 애플리케이션 소스
      => java         - 자바 소스 파일
      => resources    - 텍스트(.txt), 프로퍼티(.properties), XML(.xml) 등 파일 
    => test           - 단위 테스트 소스
      => java         - 자바 소스 파일
      => resources    - 텍스트(.txt), 프로퍼티(.properties), XML(.xml) 등 파일
  
4. Gradle 설정 파일 생성
  => build.gradle 파일 생성
  
5. Gradle 설정 파일 편집
  => java, eclipse 그래들 플러그인 추가
  => 의존 라이브러리 설정 추가
  
6. gradle build... 명령 실행
  => "eclipse" 명령 추가 및 실행 
  
  
  
  
  
  
  
  
  
  
  