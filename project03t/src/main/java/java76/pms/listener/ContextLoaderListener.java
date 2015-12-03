package java76.pms.listener;

import static org.reflections.ReflectionUtils.getAllMethods;

import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java76.pms.annotation.RequestMapping;

import static org.reflections.ReflectionUtils.*;

public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
        sce.getServletContext().getInitParameter("contextConfigLocation"));
        
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("iocContainer", iocContainer);
    
    //1) IoC 컨테이너에서 빈(Bean; 객체)을 꺼낸다.
    String[] beanNames = iocContainer.getBeanDefinitionNames();
    Object bean = null;
    Set<Method> methods = null;
    
    for (String name : beanNames) {
      bean = iocContainer.getBean(name);
      
      //2) 객체를 통해 @RequestMapping이 붙은 메서드를 알아낸다.
      //- getAllMethods(클래스, 조건1, 조건2, 조건3, ...)
      //- withAnnotation(애노테이션타입) ==> getAllMethods()가 사용할 조건을 리턴한다.
      methods = getAllMethods(bean.getClass(), /* 해당 객체의 클래스에서 찾는다 */ 
          withAnnotation(RequestMapping.class)/* 검색 조건 */);
      System.out.println(bean.getClass().getName());
      for (Method m : methods) {
        System.out.println("==> " + m.getName());
      }
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    
  }

}
