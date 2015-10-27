package v09.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    Socket socket = null;
    BufferedReader in = null;
    PrintStream out = null;
    String message = null;
    
    while (true) {
      System.out.println("클라이언트 요청을 기다리는 중...");
      socket = ss.accept();
      
      in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());
      
      message = in.readLine();
      out.println("aaaaaa1");
      out.println("aaaaaa2");
      out.println("aaaaaa3");
      out.println("aaaaaa4");
      out.println();
      
      in.close();
      out.close();
      socket.close();
      System.out.println("클라이언트에게 응답함!");
    }

  }

}
