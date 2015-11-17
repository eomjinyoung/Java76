//주제: 클로저 정의 - it 변수
package step04

plus = { 
  // "it" 변수?  
  // 파라미터를 선언하지 않을 경우 사용할 수 있는 변수.
  // 오직 한 개의 값만 받을 수 있다. 두 개 이상의 값이 들어오면 it을 사용할 수 없다.
  println it.getClass().getName()
  //it[0] + it[1]
}

println plus(10) // 값을 한 개 넘기면 it 변수에는 10이라는 값이 들어간다.
//println plus(10, 20) // 오류! 두 개의 값을 넘기면 it 변수를 사용할 수 없다.
println plus() // 값을 넘기지 않으면 it변수에 null을 의미하는 NullObject가 들어간다.

/* "it" 변수의 용도?
 * 1) 값을 한 개만 넣을 때 사용
 * 2) 임의의 값 여러 개를 받는 파라미터를 선언할 때 사용. "..." 파라미터를 선언하는 효과를 얻는다.
 */

plus2 = {
  sum = 0
  for (value in it) {
    sum += value
  }
  sum
}

// it 변수에는 오직 한 개의 값만 전달할 수 있기 때문에,
// 여러 개의 값을 전달하고 싶다면 List로 전달하라!
println plus2([1,2,3,4,5,6,7,8,9,10]);















