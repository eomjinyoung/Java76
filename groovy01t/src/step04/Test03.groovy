//주제: 클로저 정의 - free 변수
package step04

pi = 3.14159f; // 클로저에서 사용되는 변수를 'free' 변수라 부른다.

getCircleArea = {radius -> 
  pi * radius * radius
}

println getCircleArea(4) 