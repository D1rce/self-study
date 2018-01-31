
//全局变量 process 
//nextTick 分割小事件，执行速度快
function com(){
console.log('this is com');
}
function someCom(arg){
    console.log('someCom');
    console.log(arg);
}

// function doSomething(arg,callback){
//     someCom(arg);
//     callback();
// }
function doSomething(arg,callback){
    someCom(arg);
    process.nextTick(callback);
}
doSomething('1234',function doEnd(){
    com();
})
//