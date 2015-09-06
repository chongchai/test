var https = require('https');

https.get('https://blairstorage.blob.core.chinacloudapi.cn/transfer/azurelogo.png', function(res) {
  console.log("statusCode: ", res.statusCode);
  console.log("headers: ", res.headers);

  res.on('data', function(d) {
    process.stdout.write(d);
  });

}).on('error', function(e) {
  console.error(e);
});
