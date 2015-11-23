/* ServletRequest를 사용하여 forwarding 하는 동안 데이터 공유하기
=> Servlet01에서 발생한 예외 정보를 ServletRequest를 통해 
   OtherServlet에게 전달할 수 있다.
 
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    try {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      int a = Integer.parseInt(request.getParameter("a"));
      int b = Integer.parseInt(request.getParameter("b"));
      int result = a / b;
      out.printf("%d / %d = %d\n", a, b, result);
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher(
                                       "/step07/otherservlet");
      // ServletRequest에 오류 정보를 저장한다.
      request.setAttribute("error", e);
      
      rd.forward(request, response);
    }
    
  }
 
}








