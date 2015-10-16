/*
 * 문자열이 주어지면 괄호를 검사하여 잘 못되었을 경우
 * false를 리턴하는 함수를 만들어라! 
 */
package test01;

import java.util.Stack;

public class Test {

  static boolean check(String content) {
    Stack<Character> stack = new Stack<Character>();
    
    char c;
    for (int i = 0; i < content.length(); i++) {
      c = content.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
        continue;
      } else if (c == ')' || c == '}' || c == ']') {
        if (stack.isEmpty()) return false;
        if (c == ')' && stack.pop() != '(') return false;
        if (c == '}' && stack.pop() != '{') return false;
        if (c == ']' && stack.pop() != '[') return false;
      }
    }
    if (stack.size() > 0)
      return false;
    
    return true;
  }
  
  public static void main(String[] args) {
    String str = "test ( okok ()dd()ok { dkdkdkd [] dkddkk} sdkdfd))";
    System.out.println(check(str));
  }

}








