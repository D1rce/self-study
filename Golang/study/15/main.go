package main

import (
	"fmt"
)

type subperson struct {
	Name string
}

type person struct {
	subperson
	Name string
	Age  int
}

func main() {
	var a int = 65
	fmt.Println(a)
	b := string(a)
	fmt.Println(b)
}
