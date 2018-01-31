// //声明事件对象
// var EventEmitter = require('events').EventEmitter;
// var event = new EventEmitter();
// //注册事件
// event.on('some_event',function(){
//     console.log('this is event');
// })
// //触发事件
// setTimeout(function(){
//     event.emit('some_event');
// },1000);

// // 引入 events 模块
// var events = require('events');
// // 创建 eventEmitter 对象
// var eventEmitter = new events.EventEmitter();

// // 创建事件处理程序
// var connectHandler = function connected() {
//    console.log('连接成功。');
  
//    // 触发 data_received 事件 
//    eventEmitter.emit('data_received');
// }

// // 绑定 connection 事件处理程序
// eventEmitter.on('connection', connectHandler);
 
// // 使用匿名函数绑定 data_received 事件
// eventEmitter.on('data_received', function(){
//    console.log('数据接收成功。');
// });

// // 触发 connection 事件 
// eventEmitter.emit('connection');

// console.log("程序执行完毕。");


// //声明事件对象
// var EventEmitter = require('events').EventEmitter;
// var event = new EventEmitter();
// //注册事件
// event.on('some_event',function(arg1,arg2){
//     console.log('this is event1:' + arg1 + arg2);
// })
// event.on('some_event',function(arg1,arg2){
//     console.log('this is event2:' + arg1 + arg2);
// })
// event.emit('some_event','hehe',191)