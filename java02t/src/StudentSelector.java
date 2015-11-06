
public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] names = {
      "한정우", "박중권",   "유승우", "이승렬", "이상훈", "황유정",
      "송영호", "이지현",   "조기진", "윤태웅",
      "임은총",  "채희민", "정지호", "김대진", "김종원",
      "정다인", "김재한", "황성진", "오규영", "권민수",
      "곽장신", "이강현", "강수철", "김장석", "김응철",  "허순종"
    };
    
    int selectedNo = 0;
    for (int i = 0; i < 26; i++) {
      selectedNo = (int)(Math.random() * 26);
      System.out.print(".");
      Thread.currentThread().sleep(200);
    }
    Thread.currentThread().sleep(2000);
    selectedNo = (int)(Math.random() * 26);
    System.out.println(names[selectedNo]);

  }

}
