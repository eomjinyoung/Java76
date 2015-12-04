package java76.pms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.util.MultipartHelper;
import net.coobird.thumbnailator.Thumbnails;

@Controller
public class StudentController {
  public static final String SAVED_DIR = "/file";
  @Autowired StudentDao studentDao;

  @RequestMapping("/student/list.do")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="email") String keyword,
      @RequestParam(defaultValue="asc") String align,
        HttpServletRequest request) throws Exception {

    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);
    
    List<Student> students = studentDao.selectList(paramMap);

    request.setAttribute("students", students);

    return "/student/StudentList.jsp";

  }
  
  @RequestMapping("/student/add.do")
  public String add(
      String name,
      String email,
      String tel,
      String cid,
      String password,
      MultipartFile photofile,
      HttpServletRequest request) throws Exception {

    String newFileName = null;
    
    if (photofile != null) {
      newFileName = MultipartHelper.generateFilename(photofile.getName());  
      ServletContext servletContext = request.getServletContext();
      File attachfile = new File(
          servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
      photofile.transferTo(attachfile);
      
      makeThumbnailImage(
        servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
        servletContext.getRealPath(SAVED_DIR) + "/s-" + newFileName + ".png");
    }
    
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setTel(tel);
    student.setCid(cid);
    student.setPassword(password);
    student.setPhoto(newFileName);

    studentDao.insert(student);

    return "redirect:list.do";

  }
  
  @RequestMapping("/student/detail.do")
  public String detail(
      String email,
      HttpServletRequest request) 
          throws Exception {

    Student student = studentDao.selectOne(email);
    request.setAttribute("student", student);

    return "/student/StudentDetail.jsp";
  }

  @RequestMapping("/student/update.do")
  public String post(
      String name,
      String email,
      String tel,
      String cid,
      String photo,
      MultipartFile photofile,
      HttpServletRequest request) throws Exception {

    String newFileName = null;
    
    if (photofile != null) {
      newFileName = MultipartHelper.generateFilename(photofile.getName());  
      ServletContext servletContext = request.getServletContext();
      File attachfile = new File(
          servletContext.getRealPath(SAVED_DIR) + "/" + newFileName);
      photofile.transferTo(attachfile);
      
      makeThumbnailImage(
          servletContext.getRealPath(SAVED_DIR) + "/" + newFileName, 
          servletContext.getRealPath(SAVED_DIR) + "/s-" + newFileName + ".png");
    }
    
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setTel(tel);
    student.setCid(cid);
    
    if (newFileName != null) {
      student.setPhoto(newFileName);
    } else if (newFileName == null && photo.length() > 0) {
      student.setPhoto(photo);
    }
    
    if (studentDao.update(student) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/student/StudentAuthError.jsp";
    } 

    return "redirect:list.do";
  }
  
  @RequestMapping("/student/delete.do")
  public String delete(
      String email,
      HttpServletRequest request) throws Exception {

    if (studentDao.delete(email) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/student/StudentAuthError.jsp";
    }
    return "redirect:list.do";
  }
  
  private void makeThumbnailImage(String originPath, String thumbPath) 
      throws IOException {
    Thumbnails.of(new File(originPath))
    .size(60,44)
    .outputFormat("png")
    .outputQuality(1.0)
    .toFile(new File(thumbPath));
  }
}
