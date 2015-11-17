//주제: 클로저 파라미터 값 전달하기
package step05

// 클로저를 받아서 호출하는 메서드 정의
def doCall(compute) {
  println compute(10, 20);
}

//1) 클로저 정의
plus = {a, b ->
  a + b
}
doCall(plus) // doCall을 통해서 클로저 호출하기. => 파라미터 값으로 클로저를 넘긴다.

//2) 클로저를 따로 선언하지 않고 doCall을 호출할 때 바로 선언하기
doCall({a, b -> a - b})

doCall {a, b -> a * b} // 메서드 호출 규칙에 따르면 괄호를 생략할 수 있다.

doCall {a, b -> 
  a / b
}









