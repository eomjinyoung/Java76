//주제: 클래스 정의
package step05

// public 생략해도 public 이다.
// 소스 파일명과 같이 않아도 된다.
class Test02 {
  public void m() {
    println "okok"
  }
}

// 한 개의 그루비 파일에 여러 개의 클래스를 선언할 수 있다.
class Test03 {
  public void m() {
    println "nono"
  }
}

// 클래스 밖에 코드를 추가하면, 보통 때처럼 파일명과 같은 클래스가 생성된다.
println "haha"

// 이미 그루비 파일명으로 클래스가 생성된 후에는
// 다음과 같이 명시적으로 파일명과 같은 클래스를 선언할 수 없다.
/*
class Test01 {

}
*/