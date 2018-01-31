var http = require('http');
var querystring = require('querystring');
var url = require('url');
var util = require('util');

//post
// 服务器
// http.createServer(function (req, res) {
//   var body = "";
//   req.on('data', function (chunk) {
//     body += chunk;
//   });
//   req.on('end', function () {

//     console.log('@@@@@@@@@@@@@@@@@@@');
//     // 解析参数
//     body = querystring.parse(body);
//     // 设置响应头部信息及编码
//     //res.writeHead(200, { 'Content-Type': 'text/html; charset=utf8' });
//     // 输出表单
//     //res.write(body.name);
//     res.end(body.msg);
//   });
// }).listen(3000);

// ClientRequest post
// // 客服端
// const postData = querystring.stringify({
//   'msg' : 'Hello World!'
// });

// const options = {
//   hostname: 'localhost',
//   port: 3000,
//   path: 'http://52.80.15.83:10080/Daikin/api/global/auth',
//   method: 'POST',
//   headers: {
//     'Content-Type': 'application/x-www-form-urlencoded',
//     'Content-Length': Buffer.byteLength(postData)
//   }
// };
// // 发送
// const req = http.request(options, (res) => {
//   console.log(`状态码: ${res.statusCode}`);
//   console.log(`响应头: ${JSON.stringify(res.headers)}`);
//   res.setEncoding('utf8');
//   res.on('data', (chunk) => {
//     console.log(`响应主体: ${chunk}`);
//   });
//   res.on('end', () => {
//     console.log('响应中已无数据。');
//   });
// });

// req.on('error', (e) => {
//   console.error(`请求遇到问题: ${e.message}`);
// });

// // 写入数据到请求主体
// req.write(postData);
// req.end();


//get
//服务器
http.createServer(function (req, res) {
  var params = url.parse(req.url, true);
  res.write(util.inspect(params))
  res.end(params.query.msg);
}).listen(3000);

//客户端
const options = {
  'host': 'localhost',
  port: 3000,
  path: '/user?msg=ehehe'
};
http.get(options, (res) => {
  res.setEncoding('utf8');
  res.on('data', (chunk) => {
    console.log(`响应主体: ${chunk}`);
  });
})