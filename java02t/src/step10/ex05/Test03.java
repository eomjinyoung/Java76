package step10.ex05;

import java.util.HashMap;

public class Test03 {

  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put(1, "홍길동");
    map.put(2, "홍길동");
    map.put(3, null);
    map.put(4, null);
    map.put(null, "임꺽정");
    map.put(null, "임꺽정2"); // 기존의 null 키 값을 덮어쓴다.
    
    System.out.println(map.size());
    System.out.println(map.get(1));
    System.out.println(map.get(2));
    System.out.println(map.get(3));
    System.out.println(map.get(4));
    System.out.println(map.get(null));

  }

}
