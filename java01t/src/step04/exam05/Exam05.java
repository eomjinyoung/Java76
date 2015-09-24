/*
 * 주제: 도구 생성
 * - class
 * - 문법
 *   class 도구명 {
 *     //변수 선언
 *     //메서드 정의
 *   }
 */

package step04.exam05;

class A {
  static String hello(String name) {
    return "안녕하세요. " + name + "님!";
  }
}

public class Exam05 {
  public static void main(String[] args) {
    String str = A.hello("홍길동"); 
    System.out.println(str);
  }
}








