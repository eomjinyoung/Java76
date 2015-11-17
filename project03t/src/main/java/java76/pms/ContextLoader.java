package java76.pms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 역할: 스프링 IoC 컨테이너를 준비한다.
public class ContextLoader {
  public static ApplicationContext context;
  
  static {
    context = new ClassPathXmlApplicationContext(
        "java76/pms/application-context.xml");
  }
}





