package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    try {
      String method = request.getHeader("x-calc-method");
      int a = Integer.parseInt(request.getHeader("x-calc-a"));
      int b = Integer.parseInt(request.getHeader("x-calc-b"));
      int result = 0;
      
      switch (method) {
      case "plus": result = plus(a, b); break;
      case "minus": result = minus(a, b); break;
      }
      
      out.println("{ \"result\": " + result + "}");
    } catch (Exception e) {
      out.println("{ \"error\": \"" + e.getMessage() + "\"}");
    }
  }
  
  private int plus(int a, int b) {
    return a + b;
  }
  private int minus(int a, int b) {
    return a - b;
  }

}







