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

public class Servlet04Step2 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    //HttpSession 보관소 준비하기
    //=> 클라이언트가 보낸 세션ID를 가지고 마지막으로 요청한 시각을 알아낸다.
    //=> 현재 요청한 시각과 마지막으로 요청한 시각 사이의 시간을 알아내서,
    //=> 타임아웃 범위 안에 있으면 기존 HttpSession 객체를 리턴하고,
    //=> 타임아웃 범위를 넘었으면 새로 HttpSession 객체를 생성하여 리턴한다.
    HttpSession session = request.getSession();
    
    //보관소에 저장된 데이터 꺼내기
    String name = (String)session.getAttribute("name");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("이름: %s\n", name);
  }
 
}








