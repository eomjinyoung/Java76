package java76.pms.controller;

import java.lang.reflect.Method;

public class Test {

  public static void main(String[] args) throws Exception {
    Class clazz = Test.class;
    
    Test obj = new Test();
    Method m = clazz.getMethod("m", 
        String.class, String.class, String.class);
    
    m.invoke(obj, "aaa", "bbb", "ccc");
    m.invoke(obj, new Object[]{"aaa", "bbb", "ccc"});

  }
  
  public void m(String a, String b, String c) {
    System.out.printf("%s, %s, %s\n", a, b, b);
  }

}
