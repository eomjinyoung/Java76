/* 파라미터 값의 평균을 구하고, 그 결과를 ServletRequest에 저장한다.
*/ 
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02Aver extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    int sum = (int)request.getAttribute("sum");
    float aver = sum / 3f;
    
    // 계산 결과를 ServletRequest 보관소에 저장한다.
    request.setAttribute("aver", aver);
  }
 
}








