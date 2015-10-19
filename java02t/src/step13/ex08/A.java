package step13.ex08;

public class A {
  static int i = 100;
  int j = 200;
  
  static void m1() {
    System.out.println("m1()");
  }
  
  void m2() {
    /*A.*/i = 4000;
    j = 300;
    /*A.*/m1();
    System.out.println("m2()");
  }
  
  static class B {
    void display() {
      A.m1();
      //m2();//오류! 바깥 클래스의 인스턴스 주소를 담을 A.this 라는 변수가 없다.
    }
  }
  
  class C {
    void display() {
      /*A.*/i = 30000;
      /*A.this.*/j = 3434;
      /*A.*/B p = new /*A.*/B();
      A.m1();
      /*A.this.*/m2(); // A.this 변수가 생략되었다. A.this안에 A의 인스턴스 주소가 들어있다.
    }
  }
}
