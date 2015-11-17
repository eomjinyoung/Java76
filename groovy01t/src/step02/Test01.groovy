//주제: 변수 선언과 값 할당
package step02

//1) 변수 선언 - 동적 타입 바인딩
// => Dynamic Type Binding(동적 타입 바인딩): 할당되는 값에 의해 변수의 타입이 결정된다.

// 변수의 타입을 지정하지 않으면 값을 분석하여 자동으로 타입을 결정한다.
def a = 20    
println a.getClass().getName()

// 동일한 변수에 다른 타입의 값을 저장하면 그 변수의 타입이 변경된다.
a = "홍길동"
println a.getClass().getName()

//2) 변수 선언 - 정적 타입 바인딩
// => 변수의 타입이 결정되면 바꿀 수 없다.
// 정적 타입 바인딩 변수 선언 - 변수를 선언할 때 타입을 지정한다.
int b = 20
println b.getClass().getName()

// 정적 타입 바인딩 변수는 타입을 변경할 수 없다. 다음은 오류!
//b = "홍길동"
//println b.getClass().getName()







