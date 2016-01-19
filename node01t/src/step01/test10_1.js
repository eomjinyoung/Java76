// 요청 파라미터 값 추출하기 - 쿼리스트링 분석기 사용 안함.
var http = require('http');
var url = require('url'); 

var httpServer = http.createServer(function(request, response) {
	
	if (request.url == '/favicon.ico') {
		response.end();
		return;
	}
			
	response.writeHead(200, { // 응답헤더
		'Content-Type' : 'text/html;charset=UTF-8' 
	});
	
	
	response.write("<!DOCTYPE html>\n");
	response.write("<html>\n");
	response.write("<head>\n");
	response.write("<meta charset=\"UTF-8\">\n");
	response.write("<title>테스트</title>\n");
	response.write("</head>\n");
	response.write("<body>\n");
	response.write("<h1>URL 상세 정보</h1>\n");
	
	// 퀄리스트링을 분석하도록 지정한다. (기본은 false)
	var urlInfo = url.parse(request.url, true);
	
	// 파라미터 값 출력
	response.write("pageNo=" + urlInfo.query.pageNo + "<br>\n");
	response.write("pageSize=" + urlInfo.query.pageSize + "<br>\n");
	response.write("name=" + urlInfo.query.name + "<br>\n");
	
	response.write("</body>\n");
	response.write("</html>\n");
	
	response.end();
});

httpServer.listen(8989);
console.log("서버 실행중...");