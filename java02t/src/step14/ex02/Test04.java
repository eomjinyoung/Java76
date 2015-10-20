package step14.ex02;

import java.io.File;

public class Test04 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./bin");
    
    // 문제: 클래스 이름만 출력하라! 
    // => .class 확장자는 출력하지 않는다.
    // 예) Test04
    displayDirectory(file);
  }
  
  private static void displayDirectory(File file) {
    File[] files = file.listFiles();
    for (File f : files) {
      if(f.getName().endsWith(".class"))
        System.out.println(f.getName().replace(".class", ""));
      if (f.isDirectory()) {
        displayDirectory(f);
      }
    }
  }

}
