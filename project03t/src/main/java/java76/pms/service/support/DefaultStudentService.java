package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.service.StudentService;

@Service
public class DefaultStudentService implements StudentService {
  private static Logger log = 
      Logger.getLogger(DefaultStudentService.class);
  
  @Autowired StudentDao studentDao;
  
  public List<Student> getStudentList(
      int pageNo, 
      int pageSize, 
      String keyword, 
      String align) {
    log.debug("getStudentList() 호출됨");
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    
    return studentDao.selectList(paramMap);
  }

  public void register(Student student) {
    log.debug("register() 호출됨");
    studentDao.insert(student);
  }

  public void remove(String email) {
    log.debug("remove() 호출됨");
    studentDao.delete(email);
  }
  
  public void change(Student student) {
    log.debug("change() 호출됨");
    studentDao.update(student);
  }

  public Student retrieve(String email) {
    log.debug("retrieve(email) 호출됨");
    return studentDao.selectOne(email);
  }

  public Student retrieve(String email, String password) {
    log.debug("retrieve(email,password) 호출됨");
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    
    return studentDao.selectOneByEmailPassword(paramMap);
  }
}







