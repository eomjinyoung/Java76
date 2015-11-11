package step10;

public class A {
  B b;

  public A() {
    System.out.println("A()");
  }
  public B getB() {
    return b;
  }

  public void setB(B b) {
    System.out.println("setB()");
    this.b = b;
  }

  
}
