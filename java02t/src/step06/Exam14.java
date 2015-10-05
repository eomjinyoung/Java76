/*
 * 주제: 자바 핵심 클래스 - 랩퍼 클래스 (3)
 * - 
 *            
 */
package step06;

public class Exam14 {

  public static void main(String[] args) throws Exception {
    int v1 = 10;
    double v2 = 20;
    //1) 일반적인 방법으로 primitive 값을 전달하기
    print(v1);
    print(v2);
    
    //2) 오토박싱을 이용한 primitive 값을 전달하기
    print2(v1); // v1은 int이다. 파라미터 변수는 Object 타입이다. 오류가 나지 않는다?
    print2(v2);
    //이유?
    // v1값을 Object 참조 변수에 담으려면,
    // v1값이 인스턴스가 되어야 한다. 따라서 자바 컴파일러는
    // print2(v1) ====> print2(new Integer(v1));
    // print2(v2) ====> print2(new Double(v2));
    // 즉 autoboxing 처리한다.
    //
    // Object obj; 에서 obj 변수는 어떤 클래스의 인스턴스라도 받을 수 있다!!!
    
    
    
  }
  
  // 랩퍼 클래스가 없다면,
  // 원시 타입의 값을 받으려면 각 타입 마다 별도의 메서드를 만들어야 한다.
  public static void print(int i) {
    System.out.printf("정수=%d\n", i);
  }
  
  public static void print(double d) {
    System.out.printf("실수=%f\n", d);
  }
  
  // 랩퍼 클래스를 사용하면,
  // 모든 원시 타입의 값을 받을 수 있는 메서드를 만들 수 있다.
  public static void print2(Object obj) {
    System.out.println(obj);
  }
}





