package java76.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java76.pms.ContextLoader;
import java76.pms.dao.BoardDao;

public class BoardDeleteServlet extends HttpServlet {  
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    BoardDao boardDao = ContextLoader.context.getBean(BoardDao.class);
    
    if (boardDao.delete(no) > 0) { 
      out.println("삭제하였습니다.");
    } else {
      out.println("해당 게시물이 존재하지 않습니다.");
    }
  }
}