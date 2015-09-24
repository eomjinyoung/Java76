/*
 * 주제: 기능 정의4
 * - function = method
 * - 문법
 *   작업결과값의종류 기능명(작업할때사용할값1, 값2, 값3...) {
 *     명령어...
 *   }
 */

package step04;

public class Exam04 {

  //메서드 정의 
  //return: 있음
  //parameter: 있음
  static String hello(String name) {
    return "안녕하세요. " + name + "님!";
  }
  
  public static void main(String[] args) {
    String str = hello("홍길동"); 
    System.out.println(str);
  }

}








