package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

public class StudentListServlet extends HttpServlet {  
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int pageNo = 1;
    int pageSize = 10;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    //정렬 처리
    String keyword = "email";
    String align = "asc";
    
    if (request.getParameter("keyword") != null) {
      keyword = request.getParameter("keyword");
    }
    
    if (request.getParameter("align") != null) {
      align = request.getParameter("align");
    }
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("%-20s %-20s %-20s %-20s\n", 
        "Email", "Name", "Tel", "Cid");
    
    StudentDao studentDao = ContextLoader.context.getBean(StudentDao.class);
    
    for (Student student : studentDao.selectList(
        pageNo, pageSize, keyword, align)) {
      out.printf("%-20s, %-20s, %-20s, %-20s\n", 
          student.getEmail(),
          student.getName(),
          student.getTel(),
          student.getCid());
    }
  }
}
