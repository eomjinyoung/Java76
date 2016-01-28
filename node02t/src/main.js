/* static file 응답하기  */
var mysql = require('mysql');
var dateFormat = require('dateformat');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();

//express 모듈에 보조 장치 장착한다.
app.use(bodyParser.json()); // JSON 형식으로 넘오온 데이터 처리 
app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static('www'));

var pool  = mysql.createPool({
  connectionLimit : 10,
  host     : 'localhost',
  user     : 'java76',
  password : '1111',
  database : 'java76db'
});

pool.on('connection', function() {
	console.log('커넥션 객체가 생성되었음.');
});

app.get('/', function (request, response) {
	response.send('Express 적용 예제');
});

app.get('/board/list.do', function (request, response) {
	pool.query(
	  'select bno, title, views, cre_dt from board order by bno desc', 
	  function(err, rows, fields) { 
		  if (err) throw err;
		  response.writeHead(200, {
			'Content-Type' : 'text/html;charset=UTF-8' 
		  });
		  response.write("<!DOCTYPE html>\n");
		  response.write("<html>\n");
		  response.write("<head>\n");
		  response.write("<meta charset=\"UTF-8\">\n");
		  response.write("<title>게시판</title>\n");
		  response.write("</head>\n");
		  response.write("<body>\n");
		  response.write("<h1>게시물 목록</h1>\n");
		  response.write("<a href='form.html'>새 글</a>	\n");
		  response.write("<table>\n");
		  response.write("<tr>\n");
		  response.write("	<th>번호</th><th>제목</th><th>조회수</th><th>작성일</th>\n");
		  response.write("</tr>\n");
		  
		  for (var i = 0; i < rows.length; i++) {
			  response.write("<tr>\n");
			  response.write("  <td>" + rows[i].bno + "</td>\n");
			  response.write("  <td><a href='detail.do?no=" 
					  + rows[i].bno + "'>" 
					  + rows[i].title + "</a></td>\n");
			  response.write("  <td>" + rows[i].views + "</td>\n");
			  response.write("  <td>" + dateFormat(rows[i].cre_dt,"yyyy-mm-dd") + "</td>\n");
			  response.write("</tr>\n");
		  }
		  
		  response.write("</table>");
		  response.write("</body>\n");
		  response.write("</html>\n");
		  response.end();
	});
});

app.get('/board/detail.do', function(request, response) {
	
	pool.query(
	  'select bno, title, content, views, cre_dt from board where bno=?',
	  [request.query.no], 
	  function(err, rows, fields) { 
		  if (err) throw err;
		  response.writeHead(200, {
			'Content-Type' : 'text/html;charset=UTF-8' 
		  });
		  response.write("<!DOCTYPE html>\n");
		  response.write("<html>\n");
		  response.write("<head>\n");
		  response.write("<meta charset=\"UTF-8\">\n");
		  response.write("<title>게시판</title>\n");
		  response.write("</head>\n");
		  response.write("<body>\n");
		  response.write("<h1>게시물 상세정보</h1>\n");
		  response.write("<form action='update.do' method='post'>\n");	
		  response.write("<table border='1'>\n");
		  response.write("<tr>\n");
		  response.write("  <th>번호</th>\n");
		  response.write("  <td><input type='text' name='no' value='"
				  + rows[0].bno + "'></td>\n");
		  response.write("</tr>\n");
		  response.write("<tr>\n");
		  response.write("  <th>제목</th>\n");
		  response.write("  <td><input type='text' name='title' value='"
				  + rows[0].title + "'></td>\n");
		  response.write("</tr>\n");
		  response.write("<tr>\n");
		  response.write("  <th>내용</th>\n");
		  response.write("  <td><textarea name='content' rows='5' cols='50'>" 
				  + rows[0].content + "</textarea></td>\n");
		  response.write("</tr>\n");
		  response.write("<tr>\n");
		  response.write("  <th>조회수</th>\n");
		  response.write("  <td>" + rows[0].views + "</td>\n");
		  response.write("</tr>\n");
		  response.write("<tr>\n");
		  response.write(" <th>등록일</th>\n");
		  response.write("  <td>"
				  + dateFormat(rows[0].cre_dt,"yyyy-mm-dd") + "</td>\n");
		  response.write("</tr>\n");
		  
		  response.write("</table>\n");
		  response.write("<p>"
				  + "<input type='submit' value='변경'> "
				  + "<a href='delete.do?no=" 
				  + rows[0].bno + "'>삭제</a><p>\n");
		  response.write("</form>\n");
		  response.write("</body>\n");
		  response.write("</html>\n");
		  response.end();
	});
});

app.get('/board/delete.do', function(request, response) {
	
	pool.query(
	  "delete from board where bno=?", 
	  [request.query.no], 
	  function(err, rows, fields) {
		  if (err) throw err;
		  response.writeHead(302, {
			  'Location' : '/board/list.do' 
		  });
		  response.end();
	});
});

app.post('/board/update.do', function(request, response) {
	pool.query(
	  "update board set title=?, content=? where bno=?", 
	  [request.body.title,request.body.content,request.body.no], 
	  function(err, rows, fields) {
		  if (err) throw err;
		  response.writeHead(302, {
			  'Location' : '/board/list.do' 
		  });
		  response.end();
	});
});

app.post('/board/add.do', function(request, response) {
	pool.query(
	  "insert into board(title,content,cre_dt) values(?,?,now())", 
	  [request.body.title,request.body.content], 
	  function(err, rows, fields) {
		  if (err) throw err;
		  response.writeHead(302, {
			  'Location' : '/board/list.do' 
		  });
		  response.end();
	});
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});







