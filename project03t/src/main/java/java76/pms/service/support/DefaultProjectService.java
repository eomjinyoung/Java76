package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.ProjectDao;
import java76.pms.domain.Project;
import java76.pms.service.ProjectService;

@Service
public class DefaultProjectService implements ProjectService {
  private static Logger log = 
      Logger.getLogger(DefaultProjectService.class);
  
  @Autowired ProjectDao projectDao;
  
  public List<Project> getProjectList(
      int pageNo, int pageSize, String keyword, String align) {
    log.debug("getProjectList() 호출됨");
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align); 
    
    return projectDao.selectList(paramMap);
  }

  public void register(Project project) {
    log.debug("register() 호출됨");
    projectDao.insert(project);
  }

  public void remove(int no) {
    log.debug("remove() 호출됨");
    projectDao.delete(no);
  }
  
  public void change(Project project) {
    log.debug("change() 호출됨");
    projectDao.update(project);
  }
  
  public Project retieve(int no) {
    log.debug("retieve() 호출됨");
    return projectDao.selectOne(no);
  }
}







