package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.CourseEnrollmentDao;
import java76.pms.domain.CourseEnrollment;
import java76.pms.domain.Student;
import java76.pms.service.CourseEnrollmentService;
import java76.pms.service.StudentService;

@Service
public class DefaultCourseEnrollmentService implements CourseEnrollmentService {
  private static Logger log = 
      Logger.getLogger(DefaultCourseEnrollmentService.class);
  
  @Autowired StudentService studentService;
  @Autowired CourseEnrollmentDao enrollDao;
  
  public void enroll(CourseEnrollment enroll) {
    log.debug("enroll() 호출됨");
    enrollDao.insert(enroll);
  }
  
  public void change(CourseEnrollment enroll) {
    log.debug("change() 호출됨");
    enrollDao.update(enroll);
  }
  
  public void remove(String email) {
    log.debug("remove() 호출됨");
    enrollDao.delete(email);
  }
  
  public CourseEnrollment retrieveByEmail(String email) {
    log.debug("retrieveByEmail() 호출됨");
    return enrollDao.selectOne(email);
  }
  
  public List<CourseEnrollment> getEnrollmentList() {
    log.debug("getEnrollmentList() 호출됨");
    return enrollDao.selectList();
  }
  
  public void reject(String email) {
    log.debug("reject() 호출됨");
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("status", CourseEnrollment.STATUS_REJECT);
    
    enrollDao.updateForStatus(paramMap);
  }
  
  public void approve(String email) {
    log.debug("approve() 호출됨");
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("status", CourseEnrollment.STATUS_APPROVE);
    
    enrollDao.updateForStatus(paramMap);
    
    CourseEnrollment enroll = enrollDao.selectOne(email);
    
    Student student = new Student();
    student.setEmail(enroll.getEmail());
    student.setName(enroll.getName());
    student.setTel(enroll.getTel());
    
    studentService.register(student);
    
    // 트랜잭션 테스트 용
    /*
    enroll.setName(enroll.getName() + "12345678901234567890");
    enrollDao.update(enroll);
    */
  }
}






