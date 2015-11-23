/* ServletRequest에 저장된 데이터 사용하기
 
*/ 
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("오류가 발생했습니다.");
    
    // ServletRequest에 보관된 오류 정보를 꺼낸다.
    Exception e = (Exception)request.getAttribute("error");
    
    // Data Sink Stream 클래스를 사용하여 오류 정보를 저장한다.
    // => StringWriter : 자기가 준비한 메모리로 출력한다.
    // => PrintWriter : StringWriter에 꼽아서 printStackTrace()에 넘긴다.
    // => printStackTrace(tempOutput) : 
    //           PrintWriter를 이용하여 StringWriter에 오류 정보를 출력한다.
    StringWriter stringBuffer = new StringWriter();
    PrintWriter tempOutput = new PrintWriter(stringBuffer);
    e.printStackTrace(tempOutput);
    
    // StringWriter에 출력된 내용을 꺼내서 웹 브라우저로 전송한다.
    out.println(stringBuffer.toString());
  }
 
}








