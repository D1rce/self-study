package main

import (
	"fmt"
)

type USB interface {
	Name() string
	Connercter
}
type Connercter interface {
	Connect()
}
type Phone struct {
	name string
}

func (pc Phone) Name() string {
	return pc.name
}

func (pc *Phone) Connect() {
	fmt.Println("Connected --> ", pc.name)
}

// func Disconnect(usb USB) {
// 	//fmt.Println("Disconnect -->", usb.Name())
// 	if pc, ok := usb.(Phone); ok {
// 		fmt.Println("Disconnect -->", pc.Name())
// 		return
// 	}
// 	fmt.Println("Unknown decive.")

// }

// func Disconnect(usb interface{}) {
// 	//fmt.Println("Disconnect -->", usb.Name())
// 	switch v := usb.(type) {
// 	case Phone:
// 		fmt.Println("Disconnect -->", v.Name())
// 	default:
// 		fmt.Println("Unknown decive.")
// 	}
// }

func main() {
	a := Phone{"oppo"}
	a.Connect()
	a.name = "vivo"
	a.Connect()
	//Disconnect(a)
}
