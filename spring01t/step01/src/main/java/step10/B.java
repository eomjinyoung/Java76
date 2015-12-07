package step10;

public class B {
  C c;
  
  public B() {
    System.out.println("B()");
  }
  
  public C getC() {
    return c;
  }

  public void setC(C c) {
    System.out.println("setC()");
    this.c = c;
  }
  
}
