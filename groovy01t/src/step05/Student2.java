package step05;

public class Student2 {
  Integer no;
  String name;
  String tel;
  String email;
  
  public Integer getNo() {
    return no;
  }
  public void setNo(Integer no) {
    System.out.println("setNo()");
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    System.out.println("setName()");
    this.name = name;
  }
}
