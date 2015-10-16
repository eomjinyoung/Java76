package v05.command;

import java.util.HashMap;

// Command 규칙 적용
public class StudentDetailCommand implements Command {
  public void execute(HashMap<String,Object> params) {
    System.out.println("상세정보출력!");
  }
}
