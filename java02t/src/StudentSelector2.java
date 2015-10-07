import java.util.ArrayList;

public class StudentSelector2 {

  public static void main(String[] args) throws Exception {
    String[] names = {
      "이지현", "이강현", "이상훈", "권민수", "조기진",
      "곽장신", "이승렬", "박중권", "허순종", "송영호",
      "황성진", "오규영", "채희민", "정지호", "김대진",
      "정다인", "김재한", "임은총", "황유정", "윤태웅",
      "강수철", "김장석", "김응철", "유승우", "한정우",
      "김종원"
    };
    
    ArrayList<String> list = new ArrayList<String>();
    for (String name : names) {
      list.add(name);
    }
    
    int selectedNo = 0, count = 0;
    while (list.size() > 0) {
      selectedNo = (int)(Math.random() * list.size());
      System.out.print(list.remove(selectedNo) + " ");
      if (++count == 4) {
        System.out.println();
        count = 0;
      }
      Thread.currentThread().sleep(400);
    }

  }

}
