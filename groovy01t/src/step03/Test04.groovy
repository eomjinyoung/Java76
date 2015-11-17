//주제: 반복문 for
package step03

//1) 기본 for
for (int i = 0; i < 5; i++) 
  println i
println "-------------------"

//2) 
for (i in 0..4)
  println i
println "-------------------"

//3)
for (i in ["홍길동","임꺽정","유관순"])
  println i
println "-------------------"
  
for (entry in ["이름":"홍길동","국어":100,"수학":100,"역사":90])
println entry.key + "=" + entry.value
println "-------------------"


