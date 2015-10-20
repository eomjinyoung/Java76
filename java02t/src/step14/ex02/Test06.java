package step14.ex02;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Test06 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./bin");
    
    // 문제: 클래스 이름만 출력하라! - 또 다른 방법
    // => .class 확장자는 출력하지 않는다.
    // => 패키지명을 포함하라.
    // 예) step14.ex02.Test04
    displayDirectory("", file);
  }
  
  private static void displayDirectory(String packageName, File file) {
    File[] files = file.listFiles();
    String tmp = packageName;
    if (packageName.length() > 0) 
      tmp += ".";
    for (File f : files) {
      if(f.isFile()) {
        if (f.getName().endsWith(".class")) {
          System.out.println(tmp + f.getName().replace(".class", ""));
        }
      } else if (f.isDirectory()) {
        displayDirectory(tmp + f.getName(), f);
      }
    }
  }

}
