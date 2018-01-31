package main

import (
	"fmt"
)

func main() {
	var a Tz
	a.Increase(100)
	fmt.Println(a)
}

type Tz int

func (a *Tz) Increase(b int) {
	*a += Tz(b) // a &tz == 指针  *a tz == 值
}
