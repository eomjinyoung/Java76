// 사칙연산 서비스 만들기
var http = require('http');
var url = require('url'); 

var httpServer = http.createServer(function(request, response) {
	
	var urlInfo = url.parse(request.url, true);
	
	response.writeHead(200, { // 응답헤더
		'Content-Type' : 'text/html;charset=UTF-8' 
	});
	
	if (urlInfo.pathname != '/calc') {
		response.write("<!DOCTYPE html>\n");
		response.write("<html>\n");
		response.write("<head>\n");
		response.write("<meta charset=\"UTF-8\">\n");
		response.write("<title>테스트</title>\n");
		response.write("</head>\n");
		response.write("<body>\n");
		response.write("<h1>해당 URL을 지원하지 않습니다!</h1>\n");
		response.write("</body>\n");
		response.write("</html>\n");
		response.end();
		return;
	}
	
	response.write("<!DOCTYPE html>\n");
	response.write("<html>\n");
	response.write("<head>\n");
	response.write("<meta charset=\"UTF-8\">\n");
	response.write("<title>테스트</title>\n");
	response.write("</head>\n");
	response.write("<body>\n");
	response.write("<h1>연산결과</h1>\n");
	
	// 계산 결과 출력
	// 예) 10 + 20 = 30
	var a = parseInt(urlInfo.query.a);
	var b = parseInt(urlInfo.query.b);
	var op = urlInfo.query.op;
	var result;
	
	switch (op) {
	case '+': result = a + b; break;
	case '-': result = a - b; break;
	case '*': result = a * b; break;
	case '/': result = a / b; break;
	}
	
	response.write(a + " " + op + " " + b + " = " + result + "<br>\n");
	
	response.write("</body>\n");
	response.write("</html>\n");
	
	response.end();
});

httpServer.listen(8989);
console.log("서버 실행중...");