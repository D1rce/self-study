package main

import (
	"fmt"
)

func main() {
	// 匿名函数
	a := func() {
		fmt.Println("Func A")
	}
	a()
	// 闭包经典例子
	f := closure(10)
	fmt.Println(f(1))
	fmt.Println(f(2))

	for i := 0; i < 3; i++ {
		// defer 需调用一个函数 所以加上 ()
		// 匿名函数(闭包) 中 地址引用局部变量 i
		// return main 函数 执行 defer 引用 指向 i =3 的值
		// defer
		// 1.先进后出的原则
		// 2.函数发送严重错误也会执行
		// 3.常常处理 资源清理，异常错误等  类似于 java 的 try catch 下的 finally
		defer func() {
			fmt.Println(i)
		}()
	}

	var fs = [4]func(){}
	for i := 0; i < 4; i++ {
		// 正常的值拷贝
		defer fmt.Println("defer i = ", i)
		// 闭包思想
		defer func() {
			fmt.Println("defer_closure i =", i)
		}()
		// 闭包思想
		// 匿名函数 最后收到的 i 的值 是 4
		// 获得的是 i 的引用地址
		// 所以在下面的 调用f() 是最后的值
		fs[i] = func() {
			fmt.Println("closure i =", i)
		}
	}

	for _, f := range fs {
		f()
	}
}

func closure(x int) func(int) int {
	fmt.Println(" 1 -->", &x)
	return func(y int) int {
		fmt.Println(" 2 -->", &x)
		return x + y
	}
}
