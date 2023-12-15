package csp_test

import (
	"fmt"
	"testing"
	"time"
)

func Service() string {
	time.Sleep(time.Millisecond * 500)
	return "Done"
}

func OtherTask() {
	fmt.Print("work on something else\n")
	time.Sleep(time.Second * 1)
	fmt.Print("Task is Done .")
}

func TestTaskService(t *testing.T) {
	fmt.Println(Service())
	OtherTask()
}

func AsyncService() chan string {
	retCh := make(chan string, 1)
	go func() {
		ret := Service()
		fmt.Println("return result")
		retCh <- ret
		fmt.Println("service done .")
	}()
	return retCh
}

func TestAsyncService(t *testing.T) {
	retCh := AsyncService()
	OtherTask()
	fmt.Println(<-retCh)
	time.Sleep(time.Second * 2)
}
