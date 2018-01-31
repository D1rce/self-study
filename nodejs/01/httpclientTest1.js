var https = require('https');
var querystring = require('querystring');
var url = require('url');
var util = require('util');
const postData = querystring.stringify({
  instId: 'yxy',
  password: 'yxy',
  maintaindate: '亲爱的用户，服务器将于10月11日13:00-10月12日17:00进行为期4小时的维护升级。维护期间应用将暂时无法登录使用，给各位带来的不便敬请谅解。'
});
console.log(postData);
const options = {
  // hostname: 'newlifemulti-test.daikin-china.com.cn',
  // port: 443,
  hostname: 'localhost',
  port: 8433,
  path: '/push/managermessagepush',
  method: 'POST',
  rejectUnauthorized: false,
  //requestCert: true,
  headers: {
    // 'Content-Type': 'application/json',
    // 'Content-Length': Buffer.byteLength(postData)
    'Content-Type':'application/x-www-form-urlencoded',
    'Content-Length':postData.length,
  }
};

const req = https.request(options, (res) => {
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


