package step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step08/application-context03.xml");
    
    // @Autowired 처리후!
    System.out.println(context.getBean("c1"));
    

  }

}
