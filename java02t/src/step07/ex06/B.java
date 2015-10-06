package step07.ex06;

public class B extends A {
  int v2;
  
  public B() {
    //super(); //<--- 자바 컴파일러가 자동 삽입함.
    System.out.println("B() 호출됨.");
  }
  
}
