package step12.ex02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test04 {

  static class Student {
    String name;
    String tel;
    
    @Override
    public String toString() {
      return "Student [name=" + name + ", tel=" + tel + "]";
    }
  }
  
  public static void main(String[] args) throws Exception {
    Class clazz = String.class;
    
    Method[] methods = clazz.getMethods(); // public 메서드만 추출한다.
    
    for (Method m : methods) {
      System.out.printf("%s\n", m.getName());
      printDetail(m);
    }
  }
  
  private static void printDetail(Method m) {
    System.out.printf("  변경자: %s\n", Modifier.toString(m.getModifiers()));
    
    Class returnType = m.getReturnType();
    System.out.printf("  리턴타입: %s\n", returnType.getName());
    
    Class[] paramTypes = m.getParameterTypes();
    System.out.print("  파라미터: ");
    for (Class c : paramTypes) {
      System.out.print(c.getSimpleName() + ", ");
    }
    System.out.println();
    
  }

}







