package main

import (
	"fmt"
)

func platesBetweenCandles(s string, queries [][]int) []int {
	//sList := strings.Split(s, "|")
	// 从左到右存储盘子的数量
	sumList:= make([]int,len(s))
	// 从左到右存储蜡烛的位置
	leftCandleList := make([]int, len(s))
	// 从右边到左边存储蜡烛的位置
	rightCandleList := make([]int, len(s))
	sum:=0
	for i, ch := range s {
		if ch == '*' {
			sum++
		}
		sumList[i] = sum
	}
	l:=-1
	for i, ch := range s {
		if ch == '|' {
			l = i
		}
		leftCandleList[i] = l
	}
	r:=-1
	for i := len(s)-1; i >=0 ; i-- {
		if s[i] == '|' {
			r = i
		}
		rightCandleList[i] = r
	}

	ans := make([]int, len(queries))
	for _index, q := range queries {
		left, right := q[0], q[1]
		leftIndex, rightIndex := rightCandleList[left], leftCandleList[right]
		if rightIndex > leftIndex && rightIndex>=0 && leftIndex>=0 {
			ans[_index] = sumList[rightIndex] - sumList[leftIndex]
		}
	}
	return ans
}

func main() {
	fmt.Println(platesBetweenCandles("**|**|***|", [][]int{{2, 5}, {5, 9}}))
	fmt.Println(platesBetweenCandles("***|**|*****|**||**|*", [][]int{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}))
}
