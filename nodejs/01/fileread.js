var fs = require('fs');
//异步
fs.readFile('fildtext.txt','UTF-8',function(err,data)
{
    if(err){
        console.log('GG');
    }else{
        console.log(data);
    }
})
console.log('end1');

//同步


// var data1 = fs.readFileSync('fildtext.txt','UTF-8');
// console.log(data1 + "11111");
// console.log('end2');
