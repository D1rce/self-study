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
}

func closure(x int) func(int) int {
	// x  在java 代表的 是 final 类型
	fmt.Println(" 1 -->", &x)
	return func(y int) int {
		fmt.Println(" 2 -->", &x)
		return x + y
	}
}
