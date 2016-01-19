// insert 실행 
var mysql = require('mysql'); 

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'java76',
  password : '1111',
  database : 'java76db'
});

connection.connect();

// select 질의하기
connection.query(
  'insert into board(title,content,cre_dt) values(?,?,now())', 
  ['title...한글', 'content....'], // in-param에 들어갈 값을 배열에 담는다.
  function(err, rows, fields) {
	  if (err) throw err;
	  
	  console.log("입력 성공!");
});


connection.end();
