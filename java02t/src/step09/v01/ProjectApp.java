/*
 * 작업 목표:
 * - 사용자에게 명령 프롬프트를 출력한다.
 * - 사용자에게서 명령어를 입력 받아 출력한다.
 * - 예)
 *   명령> help
 *   help
 */
package step09.v01;

import java.util.Scanner;

public class ProjectApp {

  public static void main(String[] args) {
    System.out.print("명령>");
    Scanner scanner = new Scanner(System.in);
    String command = scanner.nextLine(); 
    System.out.println(command);
    scanner.close();
  }

}
