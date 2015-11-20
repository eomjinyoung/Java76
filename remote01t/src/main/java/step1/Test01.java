package step1;

public class Test01 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");
    Calculator calc = new Calculator();
    CalculatorSkel calcServer = new CalculatorSkel(calc, 8787);
    calcServer.service();
  }
}
