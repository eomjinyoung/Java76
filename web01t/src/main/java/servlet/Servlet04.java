/* 서블릿 컨텍스트에 값 넣기 테스트
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    
    ServletContext context = request.getServletContext();
    
    String attrName = request.getParameter("attrName");
    String attrValue = request.getParameter("attrValue");
    String command = request.getParameter("command");
    
    switch (command) {
    case "set": context.setAttribute(attrName, attrValue); break;
    default: context.removeAttribute(attrName);
    }
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ServletContext에 값을 저장하거나 변경, 삭제하였습니다.");
  }
 
}








