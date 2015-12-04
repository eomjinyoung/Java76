import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector3 {

  // 2인 1조 
  public static void main(String[] args) throws Exception {
    String[] names = {
        "김종원", "강수철", "이강현", "이지현", "송영호", "이승렬",
      "김재한", "오규영", "김응철", "정다인", "이상훈", "채희민"
    };
    
    String[] names2 = {
        "박중권", "임은총", "한정우", "조기진",  "김대진", "권민수", 
        "윤태웅", "정지호", "곽장신", "유승우", "허순종", "김장석", "황유정"  
    };
    
    String[] names3 = {
        "송영호", "송영호", "송영호x", "송영호", "송영호", "송영호",
        "송영호", "송영호", "송영호", "송영호", "송영호", "송영호"
       
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
      for (int i = 0; i < (int)(Math.random() * 100); i++) ;
      selectedNo = (int)(Math.random() * list.size());
      System.out.print(list.remove(selectedNo) + " ");
      
      for (int i = 0; i < (int)(Math.random() * 100); i++) ;
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
