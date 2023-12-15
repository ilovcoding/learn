package client

import (
	"go-learn/geektime/ch15/services"
	"testing"
)

func TestPackage(t *testing.T) {
	t.Log(services.GetFibonacciSerie(15))
}
