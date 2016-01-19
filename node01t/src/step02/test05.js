// delete 실행 
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
  "delete from board where title=?", 
  ['okok'], 
  function(err, rows, fields) {
	  if (err) throw err;
	  
	  console.log("삭제 성공!");
});


connection.end();
