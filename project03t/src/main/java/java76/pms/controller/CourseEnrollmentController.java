package java76.pms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.dao.CourseEnrollmentDao;
import java76.pms.dao.StudentDao;
import java76.pms.domain.CourseEnrollment;
import java76.pms.domain.Student;

@Controller
@RequestMapping("/enroll/*")
public class CourseEnrollmentController {
  @Autowired CourseEnrollmentDao enrollDao;
  @Autowired StudentDao studentDao;

  @RequestMapping("list")
  public String list(Model model) throws Exception {
    List<CourseEnrollment> list = enrollDao.selectList();
    model.addAttribute("enrolls", list);
    return "enroll/EnrollList";
  }
  
  
  @RequestMapping(value="add", method=RequestMethod.GET)
  public String form() {
    return "enroll/EnrollForm";
  }
  

  @RequestMapping(value="add", method=RequestMethod.POST)
  public String add(
      String name,
      String email,
      String tel) throws Exception {

    CourseEnrollment enroll = new CourseEnrollment();
    enroll.setName(name);
    enroll.setEmail(email);
    enroll.setTel(tel);
    enrollDao.insert(enroll);

    return "redirect:list.do";

  }
  
  @RequestMapping("detail")
  public String detail(String email, Model model) 
          throws Exception {
    CourseEnrollment enroll = enrollDao.selectOne(email);
    model.addAttribute("enroll", enroll);

    return "enroll/EnrollDetail";
  }

  @RequestMapping("update")
  public String update(
      String name,
      String email,
      String tel) throws Exception {

    CourseEnrollment enroll = new CourseEnrollment();
    enroll.setName(name);
    enroll.setEmail(email);
    enroll.setTel(tel);
    enrollDao.update(enroll);
    
    return "redirect:list.do";
  }

  @RequestMapping("delete")
  public String delete(String email, Model model) throws Exception {
    enrollDao.delete(email);   
    return "redirect:list.do";
  }
  
  @RequestMapping("reject")
  public String reject(String email) throws Exception {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("status", CourseEnrollment.STATUS_REJECT);
    
    enrollDao.updateForStatus(paramMap);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("approve")
  public String approve(String email) throws Exception {
    // 수강신청 정보를 승인 상태로 변경한다.
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("status", CourseEnrollment.STATUS_APPROVE);
    
    enrollDao.updateForStatus(paramMap);
    
    // 수강신청자 정보를 학생 테이블에 입력한다.
    //1) 수강 신청자 정보를 가져온다.
    CourseEnrollment enroll = enrollDao.selectOne(email);
    
    //2) 수강 신청자 정보를 가지고 학생 정보를 만들어 학생 테이블에 등록한다.
    Student student = new Student();
    student.setEmail(enroll.getEmail());
    student.setName(enroll.getName() + "12345678901234567890");
    student.setTel(enroll.getTel());
    
    studentDao.insert(student);
    
    return "redirect:list.do";
  }
  
 
}
