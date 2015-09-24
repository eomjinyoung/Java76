package step04.exam09;

class Calculator2 {
  // result 변수를 개별관리 변수로 선언한다. => static 명령을 제거하라!
  // static이 붙지 않은 변수는 new 명령을 통해 준비된다.
  // static이 붙은 변수는 클래스를 사용할 때 자동으로 준비된다.
  int result; 
  
  static void plus(Calculator2 that, int a) {
    that.result = that.result + a;
  }
  
  static void minus(Calculator2 that, int a) {
    that.result = that.result - a;
  }
  
  static void multiple(Calculator2 that, int a) {
    that.result = that.result * a;
  }

  static void divide(Calculator2 that, int a) {
    that.result = that.result / a;
  }
  
}
