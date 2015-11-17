//주제: if ~ else
package step03

age = 17

//1) if ~ else
if (age >= 18) {
  println "성인이다."
} else {
  println "미성년자이다."
}

//2) if ~ else if ~ else
if (age < 8) 
  println "유아"
else if (age >= 8 && age < 14)
  println "어린이"
else if (age >= 14 && age < 19)
  println "청소년"
else 
  println "성인"
  

//3) 조건 연산자
println ((age < 8) ? "유아" : "청소년")
  
  
    
  