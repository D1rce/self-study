
function hello(){
    var name;
    this.setName = function(ttt){
        name = ttt;
    }
    this.sayHello = function(){
        console.log('Hello :' + name);
    }
}
// 声明hello 对象
module.exports = hello;