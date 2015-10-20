package step14.ex02;

public class Test03 {
  
  public static void main(String[] args) {
    System.out.println(sigma(10));
  }
  
  //재귀호출
  //=> 장점: 코드가 간결하다. 수학 공식을 그대로 옮겨 놓을 수 있다.
  //=> 단점: 너무 깊은 단계로 들어가면(depth가 너무 깊으면), 스택 오버플로가 발생할 수 있다. 
  //=> 호출 구조가 자신을 다시 호출하는 형태라는 얘기지, 그냥 함수 호출일 뿐이다.
  public static int sigma(int n) {
    if (n == 1)
      return n;
    return n + sigma(n-1);
  }
}
