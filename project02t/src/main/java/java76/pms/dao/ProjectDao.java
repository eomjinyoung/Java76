package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Project;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class ProjectDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }
  
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public ProjectDao() {}

  public List<Project> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("java76.pms.dao.ProjectDao.selectList");
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int insert(Project project) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "insert into project(title,sdt,edt,member) values(?,?,?,?)");
      
      stmt.setString(1, project.getTitle());
      stmt.setDate(2, project.getStartDate());
      stmt.setDate(3, project.getEndDate());
      stmt.setString(4, project.getMember());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }

  public int delete(int no) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "delete from project where pno=?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(Project project) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "update project set title=?,sdt=?,edt=?,member=? where pno=?");
      
      stmt.setString(1, project.getTitle());
      stmt.setDate(2, project.getStartDate());
      stmt.setDate(3, project.getEndDate());
      stmt.setString(4, project.getMember());
      stmt.setInt(5, project.getNo());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
}







