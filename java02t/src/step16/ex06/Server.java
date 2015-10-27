package step16.ex06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/*
 * 계산기 서버 구현
 */
public class Server  {
  static class CalculatorAgent implements Runnable {
    Socket socket;
    
    public CalculatorAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      BufferedReader in = null;
      PrintStream out = null;
      
      try {
        in = new BufferedReader(
                new InputStreamReader(
                  socket.getInputStream()));
        
        out = new PrintStream(socket.getOutputStream()); 
        
        String message = in.readLine();
        System.out.println(message); // 예) op=+&a=10&b=20
        
        String[] params = message.split("&");
        //예) ["a=10","b=20","op=+"]
        
        HashMap<String,String> map = new HashMap<String,String>();
        String[] keyValue = null;
        for (String param : params) {
          keyValue = param.split("="); // 예)["a","10"]
          map.put(keyValue[0], keyValue[1]);
        }
        
        int a = Integer.parseInt(map.get("a"));
        int b = Integer.parseInt(map.get("b"));
        int result = 0;
        
        switch (map.get("op")) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default:
          out.println("지원하지 않는 연산자입니다.");
          return;
        }
        out.println(result);
        
      } catch (Exception e) {
        e.printStackTrace();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public void service() {
    try (ServerSocket ss = new ServerSocket(8888);) 
    {
        System.out.println("클라이언트의 연결 기다림...");
        Socket socket = null;
        
        while (true) {
          socket = ss.accept();
          new Thread(new CalculatorAgent(socket)).start();
        }
        
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    Server server = new Server();
    server.service();
  }
}





