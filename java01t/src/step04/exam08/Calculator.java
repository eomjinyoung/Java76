package step04.exam08;

class Calculator {
  static int result; //정수 메모리는 0으로 초기화된다.
  
  static void plus(int a) {
    result = result + a;
  }
  
  static void minus(int a) {
    result = result - a;
  }
  
  static void multiple(int a) {
    result = result * a;
  }

  static void divide(int a) {
    result = result / a;
  }
  
}
