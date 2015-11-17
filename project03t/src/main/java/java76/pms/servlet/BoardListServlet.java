package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

public class BoardListServlet extends GenericServlet {  
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    //페이징 처리
    int pageNo = 1;
    int pageSize = 10;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    //정렬 처리
    String keyword = "no";
    String align = "desc";
    
    if (request.getParameter("keyword") != null) {
      keyword = request.getParameter("keyword");
    }
    
    if (request.getParameter("align") != null) {
      align = request.getParameter("align");
    }
    
    PrintWriter out = response.getWriter();
    out.printf("%-3s %-20s %-3s %-10s\n", 
        "No", "Title", "Views", "Date");
    
    BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);
    
    for (Board board : boardDao.selectList(pageNo, pageSize, keyword, align)) {
      out.printf("%-3d %-20s %-3d %-10s\n", 
          board.getNo(),
          board.getTitle(),
          board.getViews(),
          board.getCreatedDate());
    }
  }

}
