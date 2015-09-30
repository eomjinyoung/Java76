/*
 * 주제: 반복문 제어 - continue
 * -> 즉시 감소/증가문으로 실행을 옮긴다.
 */
package step03;

public class Exam08 {
  public static void main(String[] args) {
    int count = 0; 
    while (count < 10) {
      if (count++ == 6)
        continue; // 조건문으로 즉시 이동.
      System.out.print(count);
    }
    
    System.out.println("\n----------------");
    
    for (int i = 0; i < 10; i++) {
      if (i == 6)
        continue; // 증가/감소문으로 즉시 이동.
      System.out.print(i);
    }
  }
}






  
  







