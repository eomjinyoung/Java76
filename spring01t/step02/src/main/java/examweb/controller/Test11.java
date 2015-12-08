package examweb.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/test11/*") 
public class Test11 {
  private static final Logger logger = Logger.getLogger(Test11.class); 
  
  @RequestMapping("e1")
  public String e1(
      String name, 
      int age,
      Date birthDate,
      Model model) throws Exception {
    logger.debug("e1() 호출됨");
    
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    model.addAttribute("birthDate", birthDate);
    
    return "/test11/e1.jsp";
  }
  
}








