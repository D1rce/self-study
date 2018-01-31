//开启http服务，坚挺端口为3000
//supervisor app.js 热监听
var http = require('http');
var url = require('url');
var util = require('util');
http.createServer(function(req,res){

    res.writeHead(200,{'Content-Type':'text/html'});
    res.write(util.inspect(url.parse(req.url,false)));
    res.end();
 }
).listen(3000);
console.log('server');