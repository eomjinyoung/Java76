//주제: String과 GString
package step05

//1) 문자열 표현
println "큰 따옴표 사용"
println '작은 따옴표 사용 가능!'
println "큰 따옴표 안에 '작은 따옴표'를 넣을 수 있다."
println '작은 따옴표 안에 "큰 따옴표"를 넣을 수 있다.'
println "큰 따옴표 안에 \"큰 따옴표\"를 넣을 수 있다."
println '작은 따옴표 안에 \'작은 따옴표\'를 넣을 수 있다.'

// 큰 따옴표를 사용하든 작은 따옴표를 사용하든 
// 이스케이프 문자를 사용하지 않고 편하게 문자열을 작성하는 방법
println (/오호라.. "큰 따옴표" 하핳 '작은 따옴표'^^  /)

//2) 여러 줄에 걸쳐있는 문자열을 작성하는 방법
println """하하하
다음 줄에 작성할 수 있을까?
아무 안될텐데..."""

//3) 문자열 사이에 변수 값을 넣기 => GString
name = "홍길동"
println "안녕하세요. $name 님"   // $변수 => 변수 이름 뒤에 공백이 있어야 한다.
println "안녕하세요. ${name}님"  // $클로저 => 예) ${리턴변수}

//4) $ 명령을 일반 문자로 바꾸기 => 이스케이프 문자로 표시한다.
println "안녕하세요. \$name 님"

//5) String과 GString의 구분
str1 = "홍길동"
str2 = "나의 이름은 $name 입니다." // 중간에 파라미터가 들어간 것이 GString이다.
str3 = str1 + str2  // String + GString = String
                    // GString(str2)은 이미 실행한 결과이기 때문에 String이 된다.

println str1.getClass().getName();
println str2.getClass().getName();
println str3.getClass().getName();

//6) GString과 클로저
now = new Date()
println "오늘 날짜: $now 입니다."

// => 클로저에 파라미터가 없는 경우 : 맨 마지막 문장의 값이 리턴된다.
println "오늘 날짜(파라미터 없는 클로저1): ${new Date()} 입니다."  // 리턴 값: 오늘 날짜
println "오늘 날짜(파라미터 없는 클로저2): ${new Date();'haha'} 입니다." // 리턴 값: haha

// => 클로저에 파라미터가 있으면 그 파라미터 값이 출력된다.
//    단, << 연산자를 사용하여 파라미터에 리턴 값을 넣어야 한다. 
println "오늘 날짜(파라미터 클로저1): ${ok -> '하하하'} 입니다."
println "오늘 날짜(파라미터 클로저2): ${ok -> ok << '헐...'} 입니다."

// 파라미터에 값을 넣은 후 다른 문장을 실행할 때
// => 다른 문장은 실행된다. 단 리턴 값은 파라미터 값이다.
println "오늘 날짜(파라미터 클로저3): ${ok -> ok << '넣었다'; println 'haha'; 'okok'} 입니다."









