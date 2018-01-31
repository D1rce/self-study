
const https = require('https');

const options = {
  hostname: 'newlifemulti-test.daikin-china.com.cn',
  port: 443,
  path: '/gateway/gatewayauth?macaddress=00804F91165E&password=8D49&version=&upversion=1',
  method: 'GET',
  rejectUnauthorized: false,
};

const req = https.request(options, (res) => {
  console.log('statusCode:', res.statusCode);
  console.log('headers:', res.headers);

  res.on('data', (d) => {
    process.stdout.write(d);
  });
});

req.on('error', (e) => {
  console.error(e);
});
req.end();