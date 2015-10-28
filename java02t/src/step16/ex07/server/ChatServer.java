package step16.ex07.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
  
  class ChatAgent extends Thread {
    Socket socket;
    
    public ChatAgent(Socket socket) {
      this.socket = socket;
    }
    
    @Override
    public void run() {
      try (
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());
      ) 
      {
        String message = null;
        while (true) {
          message = in.readLine();
          if (message.equals("quit")) {
            out.println("Good bye!");
            break;
          }
          out.println(message);
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  private void service(int port) {
    try (
      ServerSocket serverSocket = new ServerSocket(port);
    ) 
    {
      System.out.println("채팅 서버 시작!");
      
      while (true) {
        // 대기열에서 소켓을 꺼낼 때까지 기다린다. => blocking
        new ChatAgent(serverSocket.accept()).start();
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println(
        "사용법: java [옵션들] step16.ex07.server.ChatServer 포트번호");
      return;
    }
    ChatServer server = new ChatServer();
    server.service(Integer.parseInt(args[0]));
  }

}
