package main

import (
	"fmt"
)

func main() {
	var numbers [5]int
	numbers[0] = 2
	numbers[3] = numbers[0] - 3
	numbers[1] = numbers[2] + 5
	numbers[4] = len(numbers)
	// 0 --> 2
	// 1 --> 5
	// 2 --> 0
	// 3 --> -1
	// 4 --> 5

	sum :=(11)

	fmt.Printf("%v\n", (sum == numbers[0]+numbers[1]+numbers[2]+numbers[3]+numbers[4]))
}
