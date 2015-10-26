package step16.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {
    Socket socket = null;
    BufferedReader in = null;
    PrintStream out = null;
    
    try (
      ServerSocket ss = new ServerSocket(8888);
    ) {
      System.out.println("클라이언트의 연결 기다림...");
      socket = ss.accept();
      System.out.println("클라이언트와 연결됨.");
      
      in = new BufferedReader(
              new InputStreamReader(
                socket.getInputStream()));
      
      out = new PrintStream(socket.getOutputStream()); 
      
      String message = in.readLine();
      System.out.printf("클라이언트로부터 받은 메시지: %s\n", message);
      
      out.println(message);
      System.out.printf("서버가 보낸 메시지: %s\n", message);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }

  }

}
