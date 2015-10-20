package step14.ex01;

import java.io.File;

public class Test04 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./test/b.txt");
    
    System.out.printf("존재 여부: %b\n", file.exists());
    
    //4) 파일 지우기
    file.delete();
  }

}
