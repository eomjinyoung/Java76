[주제: AJAX와 JSON 적용]
0. AJAX, JSON 사용을 위한 준비 
  - build.gradle 파일에 jackson-databind 라이브러리 추가
    => compile 'com.fasterxml.jackson.core:jackson-databind:2.6.4'
  - 스프링 WebMVC 설정 파일에 ContentNegotiatingViewResolver 적용
  <bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
    <property name="viewResolvers">
      <list>
        <bean class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
          <property name="prefix" value="/WEB-INF/jsp/"/>
          <property name="suffix" value=".jsp"/>
        </bean>
      </list>
    </property>
    <property name="defaultViews">
      <list>
        <bean class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
      </list>
    </property>
  </bean>  
  
1. 게시판 UI 작성
  - /webapp/board/index.html
  
2. 게시판 페이지 컨트롤러 작성
  - *.controller.ajax.BoardController.java 
  
  
  
  
  
  
  
  
  