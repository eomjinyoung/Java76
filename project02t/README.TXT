[주제: SQL 추가 문법과 mybatis 고급 기법]
1. 페이징 처리
  => xxxDao.xml의 selectList에 limit 문법 추가
  => xxxDao의 selectList() 변경
  => xxxListServlet 클래스 변경
  
2. 정렬 기능 구현 => mysql의 dynamic sql 문법 
> localhost/board/list

사용예) 게심물 번호 오름차순 정렬
> localhost/board/list?keyword=no&align=asc

사용예) 제목 내림차순 정렬
> localhost/board/list?keyword=title&align=desc

사용예) 조회수 내림차순 정렬
> localhost/board/list?keyword=views&align=desc

=> 프로젝트 정렬 기능 추가
  keyword: title, startDate, endDate, pno(default, desc)

=> 학생 정렬 기능 추가
  keyword: email, tel, name(default, asc)


3. 별명 붙이기 
  => 긴 클래스 이름 대신 짧은 별명 사용하기 
  => mybatis-config.xml 파일 변경
   

  
  
  
  
  
  
  
  
     