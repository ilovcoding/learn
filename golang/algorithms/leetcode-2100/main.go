package main

import "fmt"

// 滑动窗口
func goodDaysToRobBank(security []int, time int) (result []int) {
	length := len(security)
	left := make([]int, length)
	right := make([]int, length)
	for i := 1; i < length; i++ {
		if security[i-1] >= security[i] {
			left[i] = left[i-1] + 1
		}
		if security[length-i-1] <= security[length-i] {
			right[length-i-1] = right[length-i] + 1
		}
	}
	for i := time; i < length-time; i++ {
		if left[i] >= time && right[i] >= time {
			result = append(result, i)
		}
	}
	fmt.Println(result)
	return result
}

func main() {
	goodDaysToRobBank([]int{5, 3, 3, 3, 5, 6, 2}, 2)
}
