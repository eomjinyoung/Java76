/* ServletContextAttributeListener 구현하기
 */
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListener01 
    implements ServletContextAttributeListener {

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    //ServletContext에 데이터가 추가될 때 호출된다.
    //=> setAttribute() 메서드가 호출될 때 마다 이 메서드가 호출된다.
    System.out.printf("ServletContext에 값 추가: %s=%s\n", 
        event.getName(), event.getValue());
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    //ServletContext의 데이터가 삭제될 때 호출된다. 
    System.out.printf("ServletContext에 등록된 값 삭제: %s=%s\n", 
        event.getName(), event.getValue());
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    //ServletContext의 데이터가 변경될 때 호출된다. 
    System.out.printf("ServletContext에 등록된 값 변경: %s=%s -> %s\n", 
        event.getName(), event.getValue(),
        event.getServletContext().getAttribute(event.getName()));
    
  }

  
  
}
