package main

import (
	"fmt"
	"strconv"
)

func convertToBase7(num int) string {
	flag := ""
	str := ""
	if num < 0 {
		flag = "-"
		num = -num
	}
	for num >= 7 {
		str = strconv.Itoa(num%7) + str
		num = num / 7
	}

	return flag + strconv.Itoa(num) + str
}

func main() {
	fmt.Println(convertToBase7(100))
	fmt.Println(convertToBase7(-7))
	fmt.Println(convertToBase7(0))
}
