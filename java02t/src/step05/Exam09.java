/*
 * 주제: 생성자3 - 파라미터가 있는 생성자 추가 
 */
package step05;

public class Exam09 {
  
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;
    
    // 파라미터가 있는 생성자 추가
    // - 컴파일러는 생성자가 단 한 개라도 있으면,
    //   기본 생성자를 만들어주지 않는다.
    public Score(String name) {
      System.out.println(name);
    }
  }
  
  public static void main(String[] args) {
    // 기본 생성자가 없기 때문에 다음은 오류!
    //new Score();
    
    new Score("홍길동"); // 생성자가 원하는 값을 준다.
  }
}






