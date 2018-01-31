var util = require('util'); 
// 声明对象
function Base() { 
	this.name = 'base'; 
	this.base = 1991; 
	this.sayHello = function() { 
	console.log('Hello ' + this.name); 
	}; 
} 
Base.prototype.showName = function() { 
	console.log('showName ' + this.name);
}; 
// 声明对象
function Sub() { 
	this.name = 'sub'; 
} 
// 集成
util.inherits(Sub, Base); 
// 原有输出
var objBase = new Base(); 
objBase.showName(); 
objBase.sayHello(); 
console.log(objBase); 
var objSub = new Sub(); 
objSub.showName(); 
//objSub.sayHello(); 
console.log(objSub); 
