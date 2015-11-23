/* ServletContextListener 구현하기
 * contextInitialized() 
 *   - 웹 애플리케이션이 시작될 때 호출된다.
 *   - 웹 애플리케이션이 사용할 객체나 자원을 준비하는 코드를 넣는다.
 * contextDestroyed()
 *   - 웹 애플리케이션이 종료될 때 호출된다.
 *   - 웹 애플리케이션이 사용한 객체나 자원을 해제하는 코드를 넣는다.
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListener02 implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("ServletContextListener02.contextInitialized()");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("ServletContextListener02.contextDestroyed()");
  }
  
}
