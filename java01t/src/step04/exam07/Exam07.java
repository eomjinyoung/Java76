/*
 * 주제: 계산기 메서드를 별도로 분류한다.
 * - 클래스를 만드는 예를 보여준다.
 * - 클래스(class: classification)란?
 *   특정 역할과 관련된 메서드를 분류한 것.
 *   코드 관리가 쉽다.
 */
package step04.exam07;

public class Exam07 {

  public static void main(String[] args) {
    // 계산: 2 + 5 * 3 - 1 
    // 조건: 연산자 우선 순위 적용하지 않음. 그냥 순서대로 처리할 것.
    
    int result = 0;
    result = Calculator.plus(2, 5);
    result = Calculator.multiple(result, 3);
    result = Calculator.minus(result, 1);
    System.out.println(result);
  }

}
