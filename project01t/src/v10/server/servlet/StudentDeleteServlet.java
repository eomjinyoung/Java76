package v10.server.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import v10.server.dao.StudentDao;

public class StudentDeleteServlet implements Servlet {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
  
  public void service(HashMap<String,Object> params) {
    int no = Integer.parseInt((String)params.get("no"));

    PrintStream out = (PrintStream)params.get("out");
    try {
      studentDao.delete(no); 
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 학생이 존재하지 않습니다.");
    }
  }
}