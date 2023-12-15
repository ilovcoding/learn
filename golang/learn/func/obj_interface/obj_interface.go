package objinterface

import "fmt"

type Person struct {
	name string
	sex  string
	age  int
}

type Student struct {
	Person
	score int
}

type Teacher struct {
	Person
	subject string
}

func (s *Student) SayHello() {
	fmt.Printf("Hello")
}

func (t *Teacher) SayHello() {
	fmt.Printf("Hello2")
}

type Humaner interface {
	SayHello()
}

func mian() {
	stu := &Student{Person{name: "小明", age: 1, sex: "v"}, 10}
	stu.SayHello()
	var h Humaner = &Student{}
	h.SayHello()
}
