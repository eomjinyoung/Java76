/* HttpSession에 타임아웃 설정하기
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet04Step1 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    
    //HttpSession 보관소 준비하기
    HttpSession session = request.getSession();
    
    //보관소에 데이터 저장하기
    session.setAttribute("name", name);
    
    //세션의 타임아웃 설정하기
    //=> 지정된 시간동안 세션을 사용하지 않으면 자동으로 세션은 무효화된다.
    //=> 세션이 무효화된 상태에서 getSesssion()을 호출하면 새 HttpSession 객체를 생성한다.
    session.setMaxInactiveInterval(20); // 20초 지정
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("이름을 보관하였습니다.");
  }
 
}








