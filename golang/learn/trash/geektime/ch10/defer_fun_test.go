package ch10_fun_test

import (
	"fmt"
	"testing"
)

func Sum(ops ...int) int {
	ret := 0
	for _, op := range ops {
		ret += op
	}
	return ret
}

func Clear(t *testing.T) {
	fmt.Println("Clear resources .")
	t.Log("t log Clear resources .")
}

func TestDefer(t *testing.T) {
	defer Clear(t)
	t.Log("Started")
	panic("error …………")

}

func TestVarparam(t *testing.T) {
	t.Log(Sum(1, 2, 3, 4))
	t.Log(Sum(1, 2, 3, 4, 5))
}
