package v07.command;

import java.util.HashMap;

public interface Command {
  void execute(HashMap<String,Object> params);
}
