package step16.ex07.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

  public static void main(String[] args) {
    try (
      Socket socket = new Socket("localhost", 8888);
      BufferedReader in = new BufferedReader(
            new InputStreamReader(
                socket.getInputStream()));
        
      PrintStream out = new PrintStream(socket.getOutputStream()); 
      Scanner keyboard = new Scanner(System.in);
    ) {
      String message = null;
      
      do {
        System.out.print("> ");
        message = keyboard.nextLine();
        out.println(message);
        System.out.println(in.readLine());
      } while (!message.equals("quit"));
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
