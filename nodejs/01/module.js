//声明对象 含有 setName 和 sayHello 两个函数
var name;
exports.setName=function(ttt){
    name = ttt;
}
exports.sayHello = function(){
    console.log('Hello :' + name);
}
