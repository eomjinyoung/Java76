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
    PrintStream out = (PrintStream)params.get("out");
    out.printf("%-3s %-20s %-3s %-10s\n", 
        "No", "Title", "Views", "Date");
    
    for (Board board : boardDao.selectList()) {
      out.printf("%-3d %-20s %-3d %-10s\n", 
          board.getNo(),
          board.getTitle(),
          board.getViews(),
          board.getCreatedDate());
    }
  }
}
