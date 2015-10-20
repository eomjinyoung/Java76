package step14.ex01;

import java.io.File;

public class Test03 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./test/a.txt");
    
    System.out.printf("존재 여부: %b\n", file.exists());
    
    //3) 파일 이름 바꾸기
    file.renameTo(new File("./test/b.txt"));
  }

}
