package v08.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import v08.domain.Board;
import v08.exception.DaoException;

// 데이터의 지속성(persistence)을 관리
// => 등록(Create), 조회(Read/Retrieve), 변경(Update), 삭제(Delete)를 관리
// => 이런 기능을 CRUD 라고 부른다.
public class BoardDao {
  ArrayList<Board> list = new ArrayList<Board>();
  
  public BoardDao() {
    String filename = "./data/board.dat";
    try (
      FileReader in = new FileReader(filename);
      BufferedReader in2 = new BufferedReader(in);
    ) {
      String line = null;
      while ((line = in2.readLine()) != null) {
        list.add(new Board(line));
      }
    } catch (Exception e) {
      throw new DaoException("게시판 정보 로딩 실패!");
    }
  }
  
  public void save() {
    try (
      FileWriter out = new FileWriter("./data/board.dat");
      BufferedWriter out2 = new BufferedWriter(out);
      PrintWriter out3 = new PrintWriter(out2);
    ) {
      for (Board board : list) {
        out3.println(board);
      }
    } catch (Exception e) {
      throw new DaoException("게시판 정보 저장 실패!");
    }
  }

  public ArrayList<Board> selectList() {
    return list;
  }

  public void insert(Board board) {
    list.add(board);
  }

  public Board delete(int no) {
    return list.remove(no);
  }
}







