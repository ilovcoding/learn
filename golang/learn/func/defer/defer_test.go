package defer_test

import (
	"fmt"
	"testing"
)

func main() {
	fmt.Println(1)
	defer fmt.Println(2)
	defer fmt.Println(3)
	fmt.Println(4)
}

//  输出 1 4 3 2
func TestRun(t *testing.T) {
	main()
}
