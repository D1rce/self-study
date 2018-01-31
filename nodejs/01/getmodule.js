//引用了同一个对象没有实例化
var module1 = require('./module');
module1.setName('dan');
var module2 = require('./module');
module2.setName('jhon');
module1.sayHello();
//实例化实现
console.log('@@@@@@@@@@@@@@@@@@@@@@@@@@');
var hehe = require('./singlemodule');
var singlemodule1 = new hehe();
singlemodule1.setName('dan1');
var haha = require('./singlemodule');
var singlemodule2 = new haha();
singlemodule2.setName('jhon2');
singlemodule1.sayHello();
singlemodule2.sayHello();
//package.json文件的main来获取
console.log('@@@@@@@@@@@@@@@@@@@@@@@@@@');
var heihei = require('../packagetest');
heihei.say();