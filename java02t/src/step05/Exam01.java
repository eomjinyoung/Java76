/*
 * 주제: 반복해서 사용하는 명령어들은 별도로 분리하여 정의한다. - 메서드    
 */
package step05;

public class Exam01 {
  
  static class Score {
    String name;
    int[] subjects = new int[5];
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {
    Score[] scores = {
        new Score(),
        new Score(),
        new Score()
    }; 
    
    setInfo(scores[0], "홍길동", 100, 100, 100, 100, 100);
    print(scores[0]);
    
    setInfo(scores[1], "임꺽정", 90, 90, 90, 90, 90);
    print(scores[1]);
    
    setInfo(scores[2], "신채호", 80, 80, 80, 80, 80);
    print(scores[2]);
  }
  
  // 아규먼트를 받아서 처리하는 메서드
  // score 파라미터: 성적정보 아규먼트를 받는 변수
  public static void print(Score score) {
    System.out.printf("%s: %d, %f\n", 
        score.name, score.sum, score.aver);
  }
  // 성적 정보를 Score 인스턴스에 저장하는 메서드 
  // score: 성정을 담을 인스턴스의 주소
  // name, kor, eng, math, soc, sci: 성정 정보 
  public static void setInfo(Score score, 
      String name, int kor, int eng, int math, int soc, int sci) {
    score.name = name;
    score.subjects[0] = kor;
    score.subjects[1] = eng;
    score.subjects[2] = math;
    score.subjects[3] = soc;
    score.subjects[4] = sci;
    
    for (int i = 0; i < score.subjects.length; i++) {
      score.sum += score.subjects[i];
    }
    
    score.aver = score.sum / (float)score.subjects.length;
  }

}






