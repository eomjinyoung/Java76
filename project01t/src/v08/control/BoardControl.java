package v08.control;

import java.util.HashMap;
import java.util.Scanner;

import v08.dao.BoardDao;
import v08.domain.Board;

public class BoardControl extends StorageMenuControl<Board> {
  BoardDao boardDao;
  
  public BoardControl() throws Exception {
    boardDao = new BoardDao();
  }
  
  public BoardControl(Scanner scanner) {
    super(scanner);
  }
  
  public void service() {
    String command = null;
    
    HashMap<String,Object> params = new HashMap<String,Object>();
    params.put("list", list);
    params.put("scanner", scanner);

    do {
      System.out.print("게시물관리> ");
      command = scanner.nextLine(); 
      switch (command) {
      case "list":
        break;
      case "add":
        break;
      case "delete":
        break;  
      case "help":
        break;
      case "main":
        boardDao.save();
        return;
      default:
        System.out.println("해당 명령을 지원하지 않습니다.");
      }
    } while (true);
  }
}
