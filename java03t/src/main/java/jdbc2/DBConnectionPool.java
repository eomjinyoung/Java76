package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  String url;
  String username;
  String password;
  
  ArrayList<Connection> list = new ArrayList<>();
  
  public DBConnectionPool(String driver, String url, String username, String password) 
      throws Exception {
    //다음 방법은 직접 클래스 이름을 명시하기 때문에,
    //다른 JDBC 드라이버에 대해서는 적용할 수 없는 단점이 있다.
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    
    //대신 다음과 같이 드라이버 클래스 이름을 받아서 클래스를 로딩한다.
    Class.forName(driver);
    
    this.url = url;
    this.username = username;
    this.password = password;
  }
  
  public Connection getConnection() throws Exception {
    Connection con = null;
    
    for (int i = 0; i < list.size(); i++) {
      con = list.get(i);
      if (con.isClosed() || !con.isValid(1000)) {
        list.remove(i--);
        continue;
      }
      System.out.println("get:" + list.size());
      return list.remove(i);
    }

    System.out.println("get:" + list.size() + ", 커넥션 객체 생성");
    return DriverManager.getConnection(url, username, password);
  }
  
  public void returnConnection(Connection con) {
    try {
      if (con.isClosed())
        return;
      
      if (!con.isValid(1000))
        return;
      
      list.add(con);
      System.out.println(list.size());
    } catch (Exception e) {}
  }
}




