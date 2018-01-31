var http = require('https');
var querystring = require('querystring');
var url = require('url');
var util = require('util');
const postData = JSON.stringify({
  version: '1.0',
  auth: {
    authid: 'newlifemulti-systemUZPbxY-dbmwl*',
    password: '70B33&os1Po4_peyU/RE.io9/NDBmwjwi=Qs#/!y=@uziS$u2wSej.bIPBRG42fU'
  }
});
console.log(postData);
const options = {
  hostname: 'api.daikin-china.com.cn',
  port: 443,
  path: '/Daikin/api/global/auth',
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Content-Length': Buffer.byteLength(postData)
  }
};

const req = http.request(options, (res) => {
  console.log(`状态码: ${res.statusCode}`);
  console.log(`响应头: ${JSON.stringify(res.headers)}`);
  res.setEncoding('utf8');
  res.on('data', (chunk) => {
    console.log(`响应主体: ${chunk}`);
  });
  res.on('end', () => {
    console.log('响应中已无数据。');
  });
});

req.on('error', (e) => {
  console.error(`请求遇到问题: ${e.message}`);
});

// 写入数据到请求主体
req.write(postData);
req.end();
