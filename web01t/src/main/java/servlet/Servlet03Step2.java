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

public class Servlet03Step2 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int math = Integer.parseInt(request.getParameter("math"));
    int hist = Integer.parseInt(request.getParameter("hist"));
    
    //HttpSession 보관소 준비하기
    HttpSession session = request.getSession();
    
    //보관소에 데이터 저장하기
    session.setAttribute("kor", kor);
    session.setAttribute("math", math);
    session.setAttribute("hist", hist);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("국어,수학,역사 점수를 보관하였습니다.");
  }
 
}








