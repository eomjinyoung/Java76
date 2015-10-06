package step07.ex06;

public class E extends C {
  int v5;
  
  public E() {
    // 수퍼 클래스에 기본 생성자가 없을 때,
    // 다음과 같이 수퍼 클래스의 다른 생성자를 호출하는
    // 문장을 명시적으로 작성하라!
    super(50); 
    System.out.println("E() 호출됨.");
  }

}
