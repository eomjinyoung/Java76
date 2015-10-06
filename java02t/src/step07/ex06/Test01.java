/*
 * 주제: 상속 관계에서 인스턴스 변수 준비
 * - 인스턴스 변수를 준비할 때 수퍼 클래스의 인스턴스 변수도 함께 준비한다. 
 */
package step07.ex06;

public class Test01 {

  public static void main(String[] args) {
    A p1 = new A();
    B p2 = new B();
    //C p3 = new C(); //오류! C 클래스는 기본 생성자가 없다.
    D p4 = new D();
    
    

  }

}
