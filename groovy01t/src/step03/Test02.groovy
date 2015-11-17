//주제: switch
package step03

value = false

switch (value) {
case 10: println "10이다."; break
case 20: println "20이다."; break
case [1,3,5,7,9]: println "홀수"; break;
case 100..200: println "100 <= 값 <= 200"; break;
case Number: println "숫자이다"; break;
case "홍길동": println "문자열도 된다."; break;
case false: println "논리값도 되네!"; break;
default: println("그밖에")
}