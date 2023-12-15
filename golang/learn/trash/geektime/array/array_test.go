package array_test

import "testing"

func TestArrayInit(t *testing.T) {
	var arr [3]int
	arr1 := [4]int{1, 2, 3, 4}
	arr3 := [...]int{1, 3, 4, 5}
	arr[1] = 5
	t.Log(arr[1], arr[2])
	t.Log(arr1, arr3)
}

func TestArrayTravel(t *testing.T) {

	arr3 := [...]int{1, 3, 4, 5}
	for i := 0; i < len(arr3); i++ {
		t.Log(arr3[i])
	}
	for _, e := range arr3 {
		t.Log(e)
	}
}

func TestArraySection(t *testing.T) {
	arr3 := [...]int{1, 2, 3, 4, 5}
	arr3_sec := arr3[:3]
	t.Log((arr3_sec))
}

func TestSliceInit(t *testing.T) {
	var s0 []int
	t.Log(s0, cap(s0))
	s0 = append(s0, 1)
	t.Log(s0, cap(s0))
	s1 := []int{1, 2, 3, 4}
	t.Log(len(s1), cap(s1))
	s2 := make([]int, 3, 5)
	t.Log(len(s2), cap(s2))
	t.Log(s2[0], s1[1], s2[3], s2[3])
}
