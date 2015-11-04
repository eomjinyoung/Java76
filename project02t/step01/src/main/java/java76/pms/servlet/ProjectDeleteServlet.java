package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.ProjectDao;

@Component("/project/delete")
public class ProjectDeleteServlet implements Servlet {
  ProjectDao projectDao;
  
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }
  
  public void service(HashMap<String,Object> params) {
    int no = Integer.parseInt((String)params.get("no"));
    
    PrintStream out = (PrintStream)params.get("out");
    try {
      projectDao.delete(no); 
      out.println("삭제하였습니다.");
    } catch (Exception e) {
      out.println("해당 번호의 프로젝트가 존재하지 않습니다.");
    }
  }

}
