package step07.ex06;

public class D extends B {
  int v4;
  
  public D() {
    //super(); //<--- 자바 컴파일러가 자동 삽입함.
    System.out.println("D() 호출됨.");
  }
  
  public void test() {
    //super(); //오류! 수퍼 클래스의 생성자 호출은 오직 생성자 메서드에서만 가능한다.
  }
}
