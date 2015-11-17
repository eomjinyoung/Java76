//주제: 메서드 정의
package step04

//메서드 호출
println plus(10, 20) // 메서드가 선언되는 위치에 상관없이 메서드 밖에 작성한 명령어는
                     // run() 메서드 안에 들어 간다.


//1) 기본 메서드 정의
//변수의 타입이 선언되지 않으면, Object 타입 변수로 선언된다.
def plus(a, b) {
  return a + b
}  

// 리턴 타입을 선언하지 않은 메서드는 def 생략 불가! 다음은 오류!
/*
minus(a, b) {
  return a - b
}
*/

// 리턴 타입이 선언된 메서드는 def 생략 가능
int minus(a, b) {
  return a - b
}

// 물론 앞에 def를 붙여도 된다.
def int minus2(a, b) {
  return a - b
}

println plus(100, 200)  // 메서드가 선언되는 위치에 상관없이 메서드 밖에 작성한 명령어는
                        // run() 메서드 안에 들어 간다.
println minus(100, 200)
println minus2(100, 200)

/* 위의 문장으로 생성되는 클래스
public class Test01 extends groovy.lang.Script {
  public Test01() {...}
  
  public static void main(String[] args) {
    ...
    run();
    ...
  }
  
  public Object run() {
    //println plus(10, 20)
    System.out.println( plus(new Integer(10), new Integer(20)) )
    //println plus(100, 200)
    System.out.println( plus(new Integer(100), new Integer(200)) )
  }
  
  public Object plus(Object a, Object b) {
    return a.intValue() + b.intValue()
  }
}
 */












