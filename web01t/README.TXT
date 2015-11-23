[주제: 웹 애플리케이션 저장소]
1. ServletRequest 
  - 저장소의 기능을 갖고 있다.
  - 요청할 때 생성되어서 응답을 완료하면 제거된다.
    따라서 이 저장소에 데이터를 넣으면 응답을 완료할 때까지만 유지된다.
2. HttpSession
  - 최초 요청이 들어오면 생성된다.
  - 세션을 강제로 무효화시키거나, 시간이 종료(timeout)될 때 제거된다.
    - 세션을 강제로 무효화시키는 경우? 로그아웃
    - 시간이 종료되는 경우? 지정한 시간동안 요청이 없을 때.
  - 따라서 이 저장소에 데이터를 넣으면 웹 브라우저를 닫거나,
    타임아웃 될 때까지 유지된다.
  - 그래서 주로 로그인 한 사용자의 주요 정보를 저장하는 용도로 사용한다.
3. ServletContext
  - 웹 애플리케이션이 시작될 때 생성되고, 종료되면 제거된다.
  - 따라서 이 저장소에는 웹 애플리케이션이 실행되는 동안 유지되어야 할 데이터를 저장한다.
    예) DAO, Spring IoC 컨테이너 등
4. PageContext
  - JSP 페이지를 실행하는 동안만 유지된다.
  - JSP 페이지와 태그 핸들러 사이에 데이터를 공유할 목적으로 사용한다.

[실습]
Servlet01.java
  - ServletRequest 보관소를 사용하여 forwarding 서블릿끼리 데이터 공유하기 

Servlet02.java, Servlet02Sum.java, Servlet02Aver.java
  - ServletRequest 보관소를 사용하여 including 서블릿끼리 데이터 공유하기

Servlet03Step1.java, Servlet03Step2.java, Servlet03Step3.java
  - HttpSession 보관소를 사용하여 서블릿끼리 데이터 공유하기

Servlet04Step1.java, Servlet04Step2.java
  - 타임아웃이 된 다음에 HttpSession이 무효화 되는 것을 확인하기 
  - Step1 서블릿을 실행한 후, 타임아웃 시간이 지난 후 Step2를 실행하면 
    Step1에서 세션에 저장한 값을 꺼낼 수 없다. => 세션이 무효화 됐기 때문이다.
    
Servlet05Login.java, Servlet05Main.java, Servlet05Logout.java
  - Logout 서블릿을 사용하여 세션을 강제 무효화시키기. 
    => 로그아웃이 이 방법을 사용한다.
       
Servlet06Step1.java, Servlet06Step2.java
  - ServletContext 보관소를 사용하여 모든 서블릿들이 공유하는 데이터 보관하기.
     

      
      
      
      
      
      
      
      
      
      