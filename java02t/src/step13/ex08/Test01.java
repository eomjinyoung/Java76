package step13.ex08;

public class Test01 {

  public static void main(String[] args) {
    A.B p1 = new A.B();
    p1.display();

    System.out.println(A.i);
    
    A p2 = new A();
    A p3 = new A();
    System.out.println(p2.i); //인스턴스를 통해서 클래스 변수에 접근할 수 있다.
    p2.i = 1000;
    System.out.println(p3.i); //인스턴스를 통해서 클래스 변수에 접근할 수 있다.
    
    // j는 인스턴스가 있어야만 사용할 수 있다.
    System.out.println(p2.j);
    
    // non-static 이너 클래스의 인스턴스 만들기
    // => 레퍼런스 변수를 선언하는 방법은 static 이너 클래스와 같다.
    A p4 = new A();
    int x = p4.i;
    
    A.C c1 = null;
    c1 = p4.new C();
    //항상 멤버 이너 클래스의 인스턴스는 바깥 클래스의 인스턴스가 존재해야만 존재할 수 있다.
  }

}
