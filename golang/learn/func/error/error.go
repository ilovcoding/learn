package main

import (
	"errors"
	"fmt"
)

func test(a int, b int) (value int, err error) {
	if b == 0 {
		return 0, errors.New("runtime error")
	} else {
		return a / b, nil
	}
}

func demo(i int) {
	var arr [10]int
	arr[i] = 100
	defer func() {
		err := recover()
		if err != nil {
			fmt.Println(err)
		}
	}()
}

func main() {

	fmt.Println("1")
	demo(10)
	fmt.Println("2")
}
