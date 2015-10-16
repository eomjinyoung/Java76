
public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] names = {
      "한정우", "박중권",  "이강현", "유승우", "이승렬",
      "이지현", "이상훈",  "조기진",
      "임은총", "황유정", "채희민", "정지호", "김대진", "김종원",
      "정다인", "김재한", "윤태웅","황성진", "오규영", "권민수",
      "곽장신", "강수철", "김장석", "김응철", "송영호", "허순종"
    };
    
    int selectedNo = 0;
    for (int i = 0; i < 26; i++) {
      selectedNo = (int)(Math.random() * 26);
      System.out.println(".(" + names[selectedNo] + ")");
      Thread.currentThread().sleep(200);
    }
    Thread.currentThread().sleep(2000);
    selectedNo = (int)(Math.random() * 26);
    System.out.println(names[selectedNo]);

  }

}
