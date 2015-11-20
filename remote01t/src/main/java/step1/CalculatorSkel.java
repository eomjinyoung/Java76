package step1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorSkel {
  Calculator calculator;
  int port;
  
  public CalculatorSkel(Calculator calculator, int port) {
    this.port = port;
    this.calculator = calculator;
  }
  
  public void service() {
    try (
        ServerSocket ss = new ServerSocket(this.port);
    ) {
      while (true) {
        try (
          Socket s = ss.accept();
          DataInputStream in = new DataInputStream(s.getInputStream());
          DataOutputStream out = new DataOutputStream(s.getOutputStream());
        ) {
          String method = in.readUTF();
          int a = in.readInt();
          int b = in.readInt();
          int result = 0;
          
          switch (method) {
          case "plus": result = calculator.plus(a, b); break;
          case "minus": result = calculator.minus(a, b); break;
          }
          out.writeInt(result);
          
        } catch (Exception e) {
          e.printStackTrace();
        } 
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}






