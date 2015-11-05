package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Board;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class BoardDao {
  DBConnectionPool dbPool;
  
  public void setDBConnectionPool(DBConnectionPool dbPool) {
    this.dbPool = dbPool;
  }

  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public BoardDao() {}

  public List<Board> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      // selectList()에 주는 값은,
      // SQL 맵퍼 파일에 정의된 namespace 이름과 sql 아이디이다.
      return sqlSession.selectList("java76.pms.dao.BoardDao.selectList");
      // 굳이 예외를 받지 않는다.
      // selectList()가 던지는 RuntimeException 예외를 그대로 호출자에게 위임할 것이다.
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int insert(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "insert into board(title,content,pwd,cre_dt) values(?,?,?,now())");
      
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setString(3, board.getPassword());
      
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
          "delete from board where bno=?");
      
      stmt.setInt(1, no);
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
  
  public int update(Board board) {
    Connection con = null;
    PreparedStatement stmt = null;
    
    try {
      con = dbPool.getConnection();
      
      stmt = con.prepareStatement(
          "update board set title=?,content=?,cre_dt=now()"
          + " where bno=? and (pwd is null or pwd=?)");
      
      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      stmt.setString(4, board.getPassword());
      
      return stmt.executeUpdate();
      
    } catch (Exception e) {
      throw new DaoException(e);
      
    } finally {
      try {stmt.close();} catch (Exception e) {}
      dbPool.returnConnection(con);
    }
  }
}







