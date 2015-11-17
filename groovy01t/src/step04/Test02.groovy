//주제: 클로저 정의
//=> 자바에서는 함수 객체를 구현할 때 보통 익명 이너 클래스로 구현한다.
package step04

// 메서드 선언
/*
def plus(a, b) {
  return a + b
}
*/

//1) 클로저 선언 
plus = { a, b /* 파라미터 선언 */ ->
  /* 메서드 본체 */ 
  println "1111"
  println "2222"
  println "3333"
  a + b // return 명령을 주지 않아도 맨 마지막 문장의 결과를 자동으로 리턴한다.
  //"오호라"
  //println "헐..." // 맨 마직막 문장의 결과가 없을 때는 null을 리턴한다.
}


//2) 클로저는 일반 메서드처럼 호출한다.
println plus(10, 20)

// 클로저의 실제 타입은 이너 클래스이다.
println plus.getClass().getName()








