/* HttpSession을 사용하여 서블릿끼리 데이터 공유하기
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet03Step3 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    //HttpSession 보관소 준비하기
    HttpSession session = request.getSession();
    
    //보관소에 저장된 데이터 꺼내기
    String name = (String)session.getAttribute("name");
    int kor = (int)session.getAttribute("kor");
    int math = (int)session.getAttribute("math");
    int hist = (int)session.getAttribute("hist");
    int sum = kor + math + hist;
    float aver = sum / 3f;
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("이름: %s\n", name);
    out.printf("국어: %d\n", kor);
    out.printf("수학: %d\n", math);
    out.printf("역사: %d\n", hist);
    out.printf("총점: %d\n", sum);
    out.printf("평균: %f\n", aver);
  }
 
}








