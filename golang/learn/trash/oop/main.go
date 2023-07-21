package main

import "fmt"

type Cat struct {
	Name  string
	Age   int
	Color string
}

func main() {

	var cat1 Cat
	cat1.Name = "小白"
	cat1.Age = 3
	cat1.Color = "#fff"
	fmt.Println("cat1=", cat1)
	fmt.Printf("cat1地址 %p", &cat1)
	a := []int{0, 0, 0} // 提供初始化表达式。
	fmt.Println((a))
	fmt.Println(*a)

}
