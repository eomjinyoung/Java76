package java76.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java76.pms.annotation.Component;
import java76.pms.domain.Project;
import java76.pms.exception.DaoException;

@Component
public class ProjectDao {
  String url;
  String username;
  String password;
  
  public ProjectDao() {
    url = "jdbc:mysql://localhost:3306/java76db";
    username = "java76";
    password = "1111";
  }

  public List<Project> selectList() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList<Project> list = new ArrayList<>();
    
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      con = DriverManager.getConnection(url, username, password);
      stmt = con.createStatement();
      rs = stmt.executeQuery("select pno,title,sdt,edt,member from project");
      
      Project project = null;
      while (rs.next()) { 
        project = new Project();
        project.setNo(rs.getInt("pno"));
        project.setTitle(rs.getString("title"));
        project.setStartDate(rs.getDate("sdt"));
        project.setEndDate(rs.getDate("edt"));
        project.setMember(rs.getString("member"));
        list.add(project);
      }
      return list;
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

  public int insert(Project project) {
    return 0;
  }

  public int delete(int no) {
    return 0;
  }
  
  public int update(Project project) {
    return 0;
  }
}







