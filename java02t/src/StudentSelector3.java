import java.util.ArrayList;
import java.util.Scanner;

public class StudentSelector3 {

  // 2인 1조 
  public static void main(String[] args) throws Exception {
    String[] names = {
      "김종원", "강수철", "이강현", "이지현", "송영호" 
    };
    
    String[] names2 = {
      "김재한", "김응철",  "이상훈", "유승우", "김장석"
    };
    
    String[] names3 = {
      "박중권", "조기진", "김대진", "권민수", "이승렬", "오규영",
      "윤태웅", "정지호", "정다인", "허순종",  "황유정"   
    };
    
    
    ArrayList<String> list = new ArrayList<String>();
    for (String name : names) {
      list.add(name);
    }
    
    ArrayList<String> list2 = new ArrayList<String>();
    for (String name : names2) {
      list2.add(name);
    }
    
    ArrayList<String> list3 = new ArrayList<String>();
    for (String name : names3) {
      list3.add(name);
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
      
      for (int i = 0; i < (int)(Math.random() * 100); i++) ;
      selectedNo = (int)(Math.random() * list3.size());
      System.out.print(list3.remove(selectedNo) + " ");
      
      for (int i = 0; i < (int)(Math.random() * 100); i++) ;
      selectedNo = (int)(Math.random() * list3.size());
      System.out.print(list3.remove(selectedNo) + " ");
      
      scanner.nextLine();
    }

  }

}
