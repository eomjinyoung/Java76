import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector3 {

  // 2인 1조 
  public static void main(String[] args) throws Exception {
    String[] names = {
      "정지호", "김장석", "이승렬", "이강현", "이상훈", "김응철",
      "김종원", "한정우", "강수철", "김대진", "김재한", "오규영"
    };
    
    String[] names3 = {
        "이지현", "권민수", "조기진", "채희민", "허순종", "송영호",
        "곽장신", "박중권", "정다인", "임은총", "황유정", "윤태웅"
        //"유승우"
    };
    String[] names2 = {
        "유승우", "유승우", "유승우x", "유승우", "유승우", "유승우",
        "유승우", "유승우", "유승우", "유승우", "유승우", "유승우"
       
    };
    
    ArrayList<String> list = new ArrayList<String>();
    for (String name : names) {
      list.add(name);
    }
    
    ArrayList<String> list2 = new ArrayList<String>();
    for (String name : names2) {
      list2.add(name);
    }
    
    Scanner scanner = new Scanner(System.in);
    int selectedNo = 0, count = 0;
    while (list.size() > 0) {
      selectedNo = (int)(Math.random() * list.size());
      System.out.print(list.remove(selectedNo) + " ");
      
      selectedNo = (int)(Math.random() * list2.size());
      System.out.print(list2.remove(selectedNo) + " ");
      
//      if (++count == 1) {
//        System.out.println();
//        count = 0;
//      }
      //Thread.currentThread().sleep(400);
      scanner.nextLine();
    }

  }

}
