package step13.ex06;

public class Member {
  //1) 클래스 변수
  static int i;
  
  //2) 인스턴스 변수
  int j;
  
  //3) 클래스 메서드
  static void m1() {}
  
  //4) 인스턴스 메서드
  void m2() {}
  
  //5) 탑 레벨 이너 클래스
  static class TopLevel {}
  
  //6) 멤버 이너 클래스
  class MemberInner {}
  
  //7) 스태틱 블록
  // => 클래스가 로딩될 때 실행된다. 딱 한 번.
  static {}
  
  //8) 인스턴스 블록
  // => 생성자처럼 인스턴스가 생성될 때 마다 실행된다.
  // => 생성자 호출 전에 먼저 실행된다.
  // => 특히 생성자를 만들 수 없는 상황!
  //    그럼에도 불구하고 인스턴스 변수를 초기화 해야 하는 상황!
  {}
  
  //9) 생성자
  Member() {}
  
}
