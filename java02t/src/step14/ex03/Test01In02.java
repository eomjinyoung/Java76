package step14.ex03;

import java.io.FileInputStream;

public class Test01In02 {
  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("./test/ex03.test01.txt");
    
    //2) 반복문을 사용하여 읽기
    //=> read():int 
    //   데이터 읽었으면 값을 리턴,
    //   파일에 끝에 도달했으면 -1 리턴.
    int b;
    while ((b = in.read()) != -1)
      System.out.printf("%02x\n", b);
    
    in.close();
    
    System.out.println("실행 완료!");
  }
}
