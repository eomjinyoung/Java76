package step14.ex03;

import java.io.FileInputStream;

public class Test01In03 {
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("./test/ex03.test01.txt");
    
    //3) 바이트 배열로 데이터를 읽어 오기
    //=> 넉넉한 크기의 빈 배열을 준비한다.
    byte[] bytes = new byte[100];
    
    //=> 읽은 바이트 수를 저장할 변수를 준비한다.
    int len = 0;
    
    //=> 바이트 배열로 데이터를 읽는다.
    len = in.read(bytes); // 이 메서드의 리턴 값은 읽은 바이트 개수이다.
    
    for (int i = 0; i < len; i++) 
      System.out.println(Integer.toHexString(bytes[i]));
    
    in.close();
    
    System.out.println("실행 완료!");
  }
}
