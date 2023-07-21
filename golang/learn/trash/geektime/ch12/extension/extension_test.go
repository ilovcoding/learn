package extension

import (
	"fmt"
	"testing"
)

type Pet struct{}

func (p *Pet) Speak() {
	fmt.Print("....\n")
}

func (p *Pet) SpeakTo(host string) {
	p.Speak()
	fmt.Println(" ", host)
}

type Dog struct {
	P *Pet
}

func (d *Dog) Speak() {
	fmt.Print("wang!!!")
}

func (d *Dog) SpeakTo(host string) {
	fmt.Print("speack to !!!")

}

func TestDog(t *testing.T) {
	var dog = &Dog{}
	dog.SpeakTo("Chao")
}
