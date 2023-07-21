package strings_test

import (
	"fmt"
	"strings"
)

func main() {
	str := "hello world"
	value := strings.Contains(str, "he")
	// true
	fmt.Println(value)
	s := []string{"1", "2", "3"}
	strings.Join(s, "-")
}
