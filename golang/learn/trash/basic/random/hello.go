package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	rand.Seed(time.Now().UnixNano())
	println(time.Now().UnixNano())
	fmt.Println("My favorite number is", rand.Intn(100))
}
