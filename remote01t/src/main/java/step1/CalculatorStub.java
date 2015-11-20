package step1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class CalculatorStub {
  String ip;
  int port;
  
  public CalculatorStub(String ip, int port) {
    this.port = port;
    this.ip = ip;
  }
  
  public int plus(int a, int b) throws Exception {
    return send("plus", a, b);
  }
  
  public int minus(int a, int b) throws Exception {
    return send("minus", a, b);
  }
  
  private int send(String method, int a, int b) throws Exception {
    try (
        Socket s = new Socket(ip, port);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
      ) {
        out.writeUTF(method);
        out.writeInt(a);
        out.writeInt(b);
        
        int result = in.readInt();
        
        return result;
        
    } catch (Exception e) {
      throw e;
    } 
  }
}






