package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Student;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class StudentDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public StudentDao() {}

  public List<Student> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("java76.pms.dao.StudentDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int insert(Student student) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "insert into student(name,email,tel,cid) values(?,?,?,?)");
      
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getEmail());
      stmt.setString(3, student.getTel());
      stmt.setString(4, student.getCid());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int delete(String email) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "delete from student where email=?");
      
      stmt.setString(1, email);
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(Student student) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "update student set name=?,tel=?,cid=? where email=?");
      
      stmt.setString(1, student.getName());
      stmt.setString(2, student.getTel());
      stmt.setString(3, student.getCid());
      stmt.setString(4, student.getEmail());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
}







