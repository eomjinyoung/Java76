package java76.pms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java76.pms.annotation.RequestMapping;
import java76.pms.dao.BoardDao;
import java76.pms.domain.Board;

@Component
public class BoardController {  
  @Autowired BoardDao boardDao;
  
  @RequestMapping("/board/list.do")
  public String list(
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    int pageNo = 1;
    int pageSize = 10;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    String keyword = "no";
    String align = "desc";
    
    if (request.getParameter("keyword") != null) {
      keyword = request.getParameter("keyword");
    }
    
    if (request.getParameter("align") != null) {
      align = request.getParameter("align");
    }
    
    List<Board> boards = boardDao.selectList(
                 pageNo, pageSize, keyword, align);
    
    request.setAttribute("boards", boards);
    
    return "/board/BoardList.jsp";
  }
  
  @RequestMapping("/board/add.do")
  public String add(
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    Board board = new Board();
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));

    boardDao.insert(board);
    
    return "redirect:list.do";
  }
  
  @RequestMapping("/board/update.do")
  public String update(
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    if (request.getMethod().equals("GET")) {
      return get(request, response);
    } else {
      return post(request, response);
    }
  }

  private String get(
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Board board = boardDao.selectOne(no);
    request.setAttribute("board", board);
    return "/board/BoardDetail.jsp";
  }

  private String post(
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    board.setPassword(request.getParameter("password"));

    if (boardDao.update(board) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/board/BoardAuthError.jsp";
    } 
    return "redirect:list.do";
  }
  
  @RequestMapping("/board/delete.do")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    String password = request.getParameter("password");

    if (boardDao.delete(no, password) <= 0) {
      request.setAttribute("errorCode", "401");
      return "/board/BoardAuthError.jsp";
    } 

    return "redirect:list.do";
  }
}
