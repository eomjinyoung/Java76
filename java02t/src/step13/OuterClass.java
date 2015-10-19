package step13;

public class OuterClass {
  //1) top level inner class
  static class TopLevel {}
  
  //2) member inner class
  class Member {}
  
  public void m() {
    //3) local inner class
    class Local {}

    //4) anonymous inner class: 서브 클래스 만들기
    new MenuControl() {
      public void test() {} // 새 메서드 추가하기
    };
    
    //5) anonymous inner class: 인터페이스 구현 클래스 만들기
    new Command() {
      public void execute() {} // 인터페이스에 선언된 메서드 구현하기
    };
    
  }
  
  class MenuControl {
    public void service() {}
  }
  
  interface Command {
    void execute();
  }
}
