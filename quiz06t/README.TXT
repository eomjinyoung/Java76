* 목표
- 애노테이션을 이용한 페이지 컨트롤러의 요청 핸들러 관리
  => 기존의 CRUD 컨트롤러를 한 컨트롤러로 합친다. 
  => @RequestMapping 애노테이션을 정의하고, 
     요청을 처리할 메서드에 붙인다.
- 요청 핸들러의 파라미터 선언을 자유롭게 하자!
  => 프론트 컨트롤러에서 페이지 컨트롤러의 메서드를 호출할 때
     파라미터를 조사하여 그에 맞는 값을 자동으로 넘겨준다.
- DAO 구현체 자동 생성
  => mybatis MapperScannerConfigurer를 사용하여 DAO 구현체를 없앤다.
  
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <!-- DAO 인터페이스가 선언된 패키지 지정한다.-->
  <property name="basePackage" value="java76.pms.dao" />
</bean>