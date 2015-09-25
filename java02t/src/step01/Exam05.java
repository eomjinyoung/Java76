/*
 * 주제: 리터럴과 변수  
 * - 데이터는 반드시 그 크기에 만족하는 변수에 저장해야 한다.
 * - 예) 4바이트 정수 => int 변수
 *      8바이트 정수 => long 변수
 * - 예외
 *      4바이트 정수 => byte, short 변수에 넣을 수 있을 때 허용! 
 */
package step01;

public class Exam05 {
  public static void main(String[] args) {
    //원칙
    int i = 10;
    long l = 10L;
    //i = 10L; // 오류! 메모리 크기가 작다.
    //short s = 10L; // 오류!
    //byte b = 10L;
    
    //예외 법칙 
    //- 4바이트 정수 데이터인 경우, 
    //  데이터가 들어 간다면 byte나 short에 넣을 수 있다.
    short s = 10;
    byte b = 10;
    
    //- 들어가지 않는다면 원래대로 오류 발생!
    //short s2 = 32768;
    //byte b2 = 128;
  }
}

















