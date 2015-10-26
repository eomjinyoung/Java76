package v08.command;

import java.util.HashMap;

import v08.dao.ProjectDao;
import v08.domain.Project;

// Command 규칙 적용
public class ProjectListCommand implements Command {
  ProjectDao projectDao;
  
  public void setProjectDao(ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  public void execute(HashMap<String,Object> params) {
    System.out.printf("%-3s %-20s %-10s %-10s %-40s\n", 
        "No", "Title", "Start", "End", "Members");
    
    int i = 0;
    for (Project project : projectDao.selectList()) {
      if (project == null) 
        continue;
      System.out.printf("% 3d %-20s %3$tY-%3$tm-%3$td %4$s %5$-40s\n", 
          i++, 
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getMember());
    }
  }
}
