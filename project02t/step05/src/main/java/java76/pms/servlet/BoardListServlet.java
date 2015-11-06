package java76.pms.servlet;

import java.io.PrintStream;
import java.util.HashMap;

import java76.pms.annotation.Component;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component("/board/list")
public class BoardListServlet implements Servlet {
  BoardDao boardDao;
  
  public void setBoardDao(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void service(HashMap<String,Object> params) {
    //페이징 처리
    int pageNo = 1;
    int pageSize = 10;
    
    if (params.get("pageNo") != null) {
      pageNo = Integer.parseInt((String)params.get("pageNo"));
    }
    
    if (params.get("pageSize") != null) {
      pageSize = Integer.parseInt((String)params.get("pageSize"));
    }
    
    //정렬 처리
    String keyword = "no";
    String align = "desc";
    
    if (params.get("keyword") != null) {
      keyword = (String)params.get("keyword");
    }
    
    if (params.get("align") != null) {
      align = (String)params.get("align");
    }
    
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-20s %-3s %-10s\n", 
        "No", "Title", "Views", "Date");
    
    for (Board board : boardDao.selectList(pageNo, pageSize, keyword, align)) {
      out.printf("%-3d %-20s %-3d %-10s\n", 
          board.getNo(),
          board.getTitle(),
          board.getViews(),
          board.getCreatedDate());
    }
  }
}
