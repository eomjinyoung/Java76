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
              new InputStreamReader(
                socket.getInputStream()));
      
        PrintStream out = new PrintStream(socket.getOutputStream()); ) 
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
        
      } finally {
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  private void service() {
    try (
        ServerSocket ss = new ServerSocket(8888);
    ) 
    {
      System.out.println("채팅 서버 시작!");
      while (true) {
        new ChatAgent(ss.accept()).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
      
    }
  }
  
  
  public static void main(String[] args) {
    ChatServer server = new ChatServer();
    server.service();

  }

}
