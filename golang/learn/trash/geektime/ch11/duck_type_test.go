package ch11_test

import "testing"

type Programmer interface {
	WriteHelloWorld() string
}

type GoProgrammer struct{}

func (g *GoProgrammer) WriteHelloWorld() string {
	return "fmt.Println(\"Hello World\")"
}

func TestClient(t *testing.T) {
	var p Programmer
	p = &GoProgrammer{}
	t.Log(p.WriteHelloWorld())
}
