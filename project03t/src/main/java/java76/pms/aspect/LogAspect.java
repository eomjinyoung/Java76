package java76.pms.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
  private static Logger log = Logger.getLogger(LogAspect.class);
  
  @After("execution(* *..service..*(..))")
  public void logServiceOperation() {
    log.debug("서비스 메서드 호출되었음.");
  }
}
