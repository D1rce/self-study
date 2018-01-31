package main 

import (
	"fmt"
)

func main() {
	mm := map[int]string{1: "a", 2: "b", 3: "c"} 
	b := mm[2]  
	mm[2] = b + "2"  
	mm[4] = ""
//	d := mm[4]
	e, ok := mm[5]
	fmt.Println("mm2-->" + mm[2])
	fmt.Println("mm4-->" + mm[4])
	fmt.Println("mm5-->" + e)
	fmt.Println(ok)
	
	
}

