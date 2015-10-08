/*
 * 작업 목표:
 * - 반복해서 사용자로부터 명령어를 입력 받는다.
 * - quit이라는 명령어를 입력할 때까지 반복한다.
 */
package step09.v02;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    String command = null;
    do {
      System.out.print("명령>");
      command = scanner.nextLine(); 
      System.out.println(command);
    } while (!command.equals("quit"));
    
    System.out.println("안녕히가세요!");
    scanner.close();
  }

}
