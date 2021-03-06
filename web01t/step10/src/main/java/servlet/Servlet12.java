package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/* 파일 업로드 - 멀티파트 데이터 처리 */
@WebServlet("/file/upload2")
public class Servlet12 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    try {
      //1) 멀티파트 데이터를 분석하여 파트 데이터를 담은 객체를 생성할 공장을 준비한다.
      DiskFileItemFactory factory = new DiskFileItemFactory();
      
      //2) 위에서 생성한 공장을 사용하여 클라이언트가 보낸 바이너리 데이터를 처리하는 객체 준비
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      //3) 요청 데이터 분석
      List<FileItem> items = upload.parseRequest(request);
      
      String name = null;
      String photo = null;
      
      //4) 파트 데이터가 담긴 객체(FileItem)에서 값을 꺼낸다.
      for (FileItem item : items) {
        if (item.isFormField()) { // 만약 일반 입력 값이라면,
          name = item.getString("UTF-8"); // 폼 값을 꺼낼 때 인코딩을 알려줘야 한다. 
          
        } else { // 업로드한 파일이라면,
          photo = item.getName(); // 파일 이름 
          File file = new File(
              this.getServletContext().getRealPath("/file")
              + "/" + photo);
          
            item.write(file);
        }
      }
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html><body>");
      out.printf("이름 = %s<br>\n", name);
      out.printf("사진 = %s<br>\n", photo);
      out.printf("<img src='%s'><br>\n", photo);
      out.println("</body></html>");
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

/* multipart/form-data 형식의 요청 프로토콜 예:
POST /web01t/file/upload HTTP/1.1
Host: localhost:8080
Content-Length: 6176
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xm...
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Int...
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7wGOI61l26HqPkkd
Referer: http://localhost:8080/web01t/file/UploadForm.jsp
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: JSESSIONID=F1099DC4A8C36AA81776205885E47FF3

------WebKitFormBoundary7wGOI61l26HqPkkd
Content-Disposition: form-data; name="name"

홍길동
------WebKitFormBoundary7wGOI61l26HqPkkd
Content-Disposition: form-data; name="photo"; filename="photo02.jpeg"
Content-Type: image/jpeg

���� JFIF      �� � 
...
------WebKitFormBoundary7wGOI61l26HqPkkd--

 */






