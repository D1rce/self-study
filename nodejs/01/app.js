//开启http服务，坚挺端口为3000
//supervisor app.js 热监听
// var http = require("http")
// http.createServer(function(req,res){
//     res.writeHead(200,{'Content-Type':'text/html'});
//     res.write('<h1>test</h1>');
//     res.end('<p>end</p>');
//  }
// ).listen(3000);
// console.log('server');

var http = require("http");

function onRequest(request, response) {
  response.writeHead(200, {"Content-Type": "text/plain"});
  response.write("Hello World");
  response.end();
}

http.createServer(onRequest).listen(3000);
