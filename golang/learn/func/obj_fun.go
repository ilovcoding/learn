package obj_fun

import "fmt"

type Stu struct {
	name string
	age  int
	sex  string
}

func (s Stu) PrintInfo() {
	fmt.Println(s.name)
	fmt.Println(s.age)
	fmt.Println(s.sex)
}

func MainPrintStudent() {
	var s1 *Stu = &Stu{name: "王", age: 18, sex: "女"}
	var s2 Stu = Stu{name: "王2", age: 19, sex: "女2"}
	s1.PrintInfo()
	fmt.Print(s1)
	s2.PrintInfo()
	fmt.Print(s2)
}
func main() {
	MainPrintStudent()
}
