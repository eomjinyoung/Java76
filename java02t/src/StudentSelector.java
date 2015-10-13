
public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] names = {
      "이지현", "이강현", "이상훈", "권민수", "조기진",
      "곽장신", "이승렬", "박중권", "허순종", "송영호",
      "황성진", "오규영", "채희민", "정지호", "김대진",
      "정다인", "김재한", "임은총", "황유정", "윤태웅",
      "강수철", "김장석", "김응철", "유승우", "한정우",
      "김종원"
    };
    
    int selectedNo = 0;
    for (int i = 0; i < 26; i++) {
      selectedNo = (int)(Math.random() * 26);
      System.out.println(".(" + names[selectedNo].charAt(0) + ")");
      Thread.currentThread().sleep(200);
    }
    Thread.currentThread().sleep(2000);
    selectedNo = (int)(Math.random() * 26);
    System.out.println(names[selectedNo]);

  }

}
