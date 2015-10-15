package step10.ex06;

import java.util.HashMap;

public class Test02 {
  
  static class Student {
    String name;
    String tel;
    
    public Student(String name, String tel) {
      this.name = name;
      this.tel = tel;
    }

    @Override
    public String toString() {
      return "Student [name=" + name + ", tel=" + tel + "]";
    }
  }
  
  public static void main(String[] args) {
    HashMap<String,Student> map = new HashMap<String,Student>();
    //map.put(1, "아무거나"); // 오류! key와 value의 타입이 맞지 않다.
    //map.put("s01", "문자열"); // 오류! value의 타입이 맞지 않다.
    map.put("s01", new Student("홍길동", "111-1111"));
    map.put("s02", new Student("임꺽정", "111-1112"));
    map.put("s03", new Student("유관순", "111-1113"));
    
    //꺼낼 때 타입 캐스팅 할 필요가 없다.
    Student s1 = map.get("s01");
    Student s2 = map.get("s02");
    Student s3 = map.get("s03");
    
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
    
  }

}








