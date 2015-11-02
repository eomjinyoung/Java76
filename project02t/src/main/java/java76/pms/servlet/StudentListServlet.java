package java76.pms.servlet;

import java.io.PrintStream;
import java.util.ArrayList ;
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
    ArrayList<Student> list = studentDao.selectList();
    PrintStream out = (PrintStream)params.get("out");
    
    Student student = null;
    for (int i = 0; i < list.size(); i++) {
      student = list.get(i); // 제네릭 적용! 타입 캐스팅 필요 없다.
      if (student == null) 
        continue;
      out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
