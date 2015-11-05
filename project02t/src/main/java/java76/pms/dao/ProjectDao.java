package java76.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java76.pms.annotation.Component;
import java76.pms.domain.Project;

@Component
public class ProjectDao {
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
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.insert(
          "java76.pms.dao.ProjectDao.insert", project);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }

  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.delete(
          "java76.pms.dao.ProjectDao.delete", no);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public int update(Project project) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update(
          "java76.pms.dao.ProjectDao.update", project);
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
}







