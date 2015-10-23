package step15.ex01;

public class Test03 {

  public static void main(String[] args) {
    // 예외 상황을 상위 호출자에게 패스하기
    try {
      compute();
    } catch (Throwable err) {
      System.out.println("예외 발생:");
      System.out.println(err.getMessage());
    }
  }
  
  // compute() 안에서 발생한 예외를 compute()에서 처리하지 않고,
  // 상위 호출자에게 패스하는 기법! 
  public static void compute() throws Throwable {
    int result = 0;
    result = Calculator2.plus(10, 20);
    result = Calculator2.multiple(result, 2);
    result = Calculator2.divide(result, 0);
    System.out.printf("결과 = %d\n", result);
  }

}





