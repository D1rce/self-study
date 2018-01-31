package main

import (
	"fmt"
	"reflect"
)

type User struct {
	Id   int
	Name string
	Age  int
}

func (u User) Hello(name string) {
	fmt.Println("Hello ", name, "My name is ", u.Name)
}

func main() {
	u := User{1, "John", 18}
	Info(&u)
	fmt.Println(u)
	v := reflect.ValueOf(u)
	mv := v.MethodByName("Hello")
	args := []reflect.Value{reflect.ValueOf("GAGA")}
	mv.Call(args)
}

func Info(o interface{}) {
	t := reflect.ValueOf(o)
	if t.Kind() == reflect.Ptr && !t.Elem().CanSet() {
		return
	}
	v := t.Elem()

	f := v.FieldByName("Name")
	if !f.IsValid() {
		fmt.Println("bad")
		return
	}

	if f.Kind() == reflect.String {
		f.SetString("Tom")
	}

}
