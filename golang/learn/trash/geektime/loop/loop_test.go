package loop_test

import "testing"

func TestWhileLoop(t *testing.T) {
	n := 0
	/* while ( n < 5 ) */
	for n < 5 {
		t.Log(n)
		n++
	}
}

func TestSliceGrowing(t *testing.T) {
	s := []int{}
	for i := 0; i < 10; i++ {
		s = append(s, i)
		t.Log((len(s)), cap(s))
	}
}

func TestSliceShareMemory(t *testing.T) {
	year := []string{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Doc"}

	Q2 := year[3:6]
	t.Log(Q2, len(Q2), cap(Q2))

}
