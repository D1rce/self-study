package main 

import (
	"fmt"
)

func main() {
	fmt.Println("hello")
	s1 :=[] int{1,2,3,4,5}
	s2 := s1[:len(s1)]
	fmt.Println(s2)
}

