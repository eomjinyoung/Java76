/* HttpSession 강제 무효화시키기
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet05Main extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    //HttpSession 보관소 준비하기
    //=> 타임아웃된 세션이거나, 세션ID가 무효할 때 새 세션 객체를 생성하여 리턴한다.
    HttpSession session = request.getSession();
    
    //보관소에 저장된 데이터 꺼내기
    String name = (String)session.getAttribute("name");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    if (name != null) {
      out.printf("이름: %s\n", name);
    } else {
      out.printf("로그인 하지 않았습니다");
    }
  }
 
}








