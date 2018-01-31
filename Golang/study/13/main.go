package main

import (
	"fmt"
)

func main() {
	// defer
	// 1.先进后出的原则
	// 2.函数发送严重错误也会执行
	// 3.常常处理 资源清理，异常错误等  类似于 java 的 try catch 下的 finally
	a()
	b()
	c()
}
func a() {
	fmt.Println("Func in a")
}
func b() {
	defer func() {
		if err := recover(); err != nil {
			fmt.Println("Recover in b")
		}
	}()
	panic("Panic in b")
}
func c() {
	fmt.Println("Func in c")
}
