/* Filter 만들기
 * => init(): 필터 객체가 생성된 후 호출됨. 필터가 사용할 자원을 준비하는 코드를 넣는다.
 * => destroy(): 필터를 제거하기 전에 호출됨. 준비한 자원을 해제하는 코드를 넣는다.
 * => doFilter(): 다음 필터로 가기 전에 호출됨. 필터가 해야할 작업을 작성한다.
 * => 웹 애플리케이션을 시작하면 web.xml에 등록된 필터 객체를 자동 생성한다.
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter02 implements Filter {
  FilterConfig config;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Filter02.init()");
    this.config = filterConfig;
  }

  @Override
  public void doFilter(
      ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("Filter02.doFilter()... 전반 작업");
    
    // 다음 필터를 실행한다. 만약 다음 필터가 없다면, 서블릿이 실행된다.
    chain.doFilter(request, response);
    
    System.out.println("Filter02.doFilter()... 후반 작업");
    
  }

  @Override
  public void destroy() {
    System.out.println("Filter02.destroy()");
    
  }

}
