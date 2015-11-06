package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;

@Component("/student/list")
public class StudentListServlet implements Servlet {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void service(HashMap<String,Object> params) {
    int pageNo = 1;
    int pageSize = 10;
    
    if (params.get("pageNo") != null) {
      pageNo = Integer.parseInt((String)params.get("pageNo"));
    }
    
    if (params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }
    
    //정렬 처리
    String keyword = "no";
    String align = "desc";
    
    if (params.get("keyword") != null) {
      keyword = (String)params.get("keyword");
    }
    
    if (params.get("align") != null) {
      align = (String)params.get("align");
    }
    
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-20s %-20s %-20s %-20s\n", 
        "Email", "Name", "Tel", "Cid");
    
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
