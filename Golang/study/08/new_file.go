package main

import "fmt"

type Person struct {
	Name   string
	Gender string
	Age    uint8
	Address string
}

func main() {

	p := Person{"Robert", "Male", 33, "Beijing"}
	
	oldAddress := p.Move("San Francisco")
	p.Grow()
	//
	fmt.Printf("%s moved from %s to %s.\n", p.Name, oldAddress, p.Address)
	fmt.Printf("age : %d ", p.Age)
}

func (person *Person) Move(Address string) (oldAddress string){
	oldAddress = person.Address
	person.Address = Address
	return
}

func (person *Person) Grow() {
	person.Age++
}
