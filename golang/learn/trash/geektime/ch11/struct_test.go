package ch11_test

import (
	"fmt"
	"testing"
	"unsafe"
)

type Emplyee struct {
	Id   string
	Name string
	Age  int
}

func TestCreateEmployeeObj(t *testing.T) {
	e := Emplyee{"0", "Bob", 20}
	e1 := Emplyee{Name: "Mike", Age: 30}
	e2 := new(Emplyee)
	e2.Id = "e2Id"
	e2.Name = "e2Name"
	e2.Age = 30
	t.Log(e)
	t.Log(e1)
	t.Log(e1.Id)
	t.Log(e2)
	t.Logf("e is %T", e)
	t.Logf("e2 is %T", e2)
}

//  直接定义 实例成员会直接复制
// func (e Emplyee) String() string {
// 	return fmt.Sprintf("ID:%s-Name:%s-Age:%d", e.Id, e.Name, e.Age)
// }

// 定义指针避免内存拷贝
func (e *Emplyee) String() string {
	fmt.Printf("*Employee Address is %x\n", unsafe.Pointer(&e.Name))
	return fmt.Sprintf("ID:%s-Name:%s-Age:%d", e.Id, e.Name, e.Age)
}

func TestStructOperations(t *testing.T) {
	e := &Emplyee{"0", "Bob", 10}
	fmt.Printf("Address is %x\n", unsafe.Pointer(&e.Name))
	t.Log(e.String())
}
