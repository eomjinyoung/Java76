/*
 * 클라이언트 각 요청에 대해 스레드를 도입한다.
 * 1) Thread 클래스를 상속 받기
 */
package v09.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import v09.server.dao.ProjectDao;
import v09.server.dao.StudentDao;
import v09.server.servlet.ProjectAddServlet;
import v09.server.servlet.ProjectDeleteServlet;
import v09.server.servlet.ProjectListServlet;
import v09.server.servlet.Servlet;
import v09.server.servlet.StudentAddServlet;
import v09.server.servlet.StudentDeleteServlet;
import v09.server.servlet.StudentListServlet;

public class ProjectServer04 {
  HashMap<String,Servlet> servletMap = new HashMap<String,Servlet>();
  
  class RequestHandler extends Thread {
    Socket socket;
    public RequestHandler(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      System.out.println("클라이언트 요청 처리...");
      try (
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
          ) 
      {
        String message = in.readLine();
        
        int i = message.indexOf('?');
        String command = message.substring(0, 
                                    (i != -1) ? i : message.length());
        
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("out", out);
        
        extractParamDataFromMessage(params, message);
        
        Servlet servlet = servletMap.get(command);
        
        if (servlet != null) {
          servlet.service(params);
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
  
  public ProjectServer04() {
    ProjectDao projectDao = new ProjectDao();
    
    ProjectListServlet projectListServlet = new ProjectListServlet();
    projectListServlet.setProjectDao(projectDao);
    servletMap.put("/project/list", projectListServlet);
    
    ProjectAddServlet projectAddServlet = new ProjectAddServlet();
    projectAddServlet.setProjectDao(projectDao);
    servletMap.put("/project/add", projectAddServlet);
    
    ProjectDeleteServlet projectDeleteServlet = new ProjectDeleteServlet();
    projectDeleteServlet.setProjectDao(projectDao);
    servletMap.put("/project/delete", projectDeleteServlet);
    
    StudentDao studentDao = new StudentDao();

    StudentListServlet studentListServlet = new StudentListServlet();
    studentListServlet.setStudentDao(studentDao);
    servletMap.put("/student/list", studentListServlet);
    
    StudentAddServlet studentAddServlet = new StudentAddServlet();
    studentAddServlet.setStudentDao(studentDao);
    servletMap.put("/student/add", studentAddServlet);
    
    StudentDeleteServlet studentDeleteServlet = new StudentDeleteServlet();
    studentDeleteServlet.setStudentDao(studentDao);
    servletMap.put("/student/delete", studentDeleteServlet);
  }
  
  public static void main(String[] args) {
    ProjectServer04 server = new ProjectServer04();
    server.execute();

  }

  private void execute() {
    try (
      ServerSocket ss = new ServerSocket(8888);
        ) 
    {
      while (true) {
        System.out.println("클라이언트 요청을 기다리는 중...");
        new RequestHandler(ss.accept()).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  private void extractParamDataFromMessage(Map<String,Object> map, String message) {
    int i = 0;
    String paramString = null;
    String[] tokens = null;
    if (message.contains("?")) {
      i = message.indexOf('?');
      paramString = message.substring(i + 1);
      tokens = paramString.split("&");
      String[] keyValue = null;
      for (String token : tokens) {
        keyValue = token.split("=");
        map.put(keyValue[0], keyValue[1]);
      }
    }
  }

}





