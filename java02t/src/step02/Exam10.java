/*
 * 주제: 관계 연산자 - <, <=, >, >=, ==, !=  
 */
package step02;

public class Exam10 {
  public static void main(String[] args) {
    int i = 10; 
    int j = 3;  
    int x = 10;
    int y = 3;
    
    System.out.println(i < j);
    System.out.println(i <= j);
    System.out.println(i <= x);
    
    System.out.println(i > j);
    System.out.println(i >= j);
    System.out.println(i >= x);
    
    System.out.println(i == x);
    System.out.println(i != x);
    
    // instanceof : 값의 유형을 검사
    System.out.println("Hello" instanceof String);
  }
}












