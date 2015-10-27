package v09.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import v09.server.dao.ProjectDao;
import v09.server.servlet.ProjectListServlet;

public class ProjectServer {
  ProjectDao projectDao;
  ProjectListServlet projectListServlet;
  
  public ProjectServer() {
    projectDao = new ProjectDao();
    projectListServlet = new ProjectListServlet();
    projectListServlet.setProjectDao(projectDao);
  }
  
  public static void main(String[] args) {
    ProjectServer server = new ProjectServer();
    server.execute();

  }

  private void execute() {
    try (
      ServerSocket ss = new ServerSocket(8888);
        ) 
    {
      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중...");
        service(ss.accept());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  private void service(Socket socket) {
    System.out.println("클라이언트 요청 처리...");
    try (
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(socket.getOutputStream());
        ) 
    {
      String message = in.readLine();
      
      HashMap<String,Object> params = new HashMap<String,Object>();
      params.put("out", out);
      
      if (message.startsWith("/project/list")) {
        projectListServlet.service(params);
      } else {
        out.println("죄송하지만, 요청하신 명령은 실행할 수 없습니다.");
      }
      out.println();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {socket.close();} catch (Exception e) {}
    }
  }

}
