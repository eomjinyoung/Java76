package step14.ex02;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class Test07 {

  public static void main(String[] args) throws Exception {
    // File 도구 사용법
    File file = new File("./bin");
    
    // 문제: 필터를 사용하여 목록으로 리턴할 파일을 선택한다.
    // => 필터 조건: .class가 아닌 파일은 목록에서 제외한다.
    // => .class 확장자 제거
    // => 패키지명 포함
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
