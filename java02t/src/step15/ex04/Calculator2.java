package step15.ex04;

public class Calculator2 {
  public static int plus(int a, int b) {
    return a + b;
  }
  
  public static int minus(int a, int b) {
    return a - b;
  }
  
  public static int multiple(int a, int b) {
    return a * b;
  }
  
  // 자바에서 제공하는 예외 클래스를 사용하는 대신,
  // 사용자(개발자)가 정의한 예외를 사용해서 오류 상황을 호출자에게 알린다.
  // => 호출자에게 어떤 오류가 발생하는 지 좀 더 구체적으로 알릴 수 있다.
  public static int divide(int a, int b) throws CalculatorException {
    if (b == 0) {
      throw new CalculatorException("0으로 나눌 수 없습니다.");
    }
    return a / b;
  }
}







