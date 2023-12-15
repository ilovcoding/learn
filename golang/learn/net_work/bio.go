package main

import (
	"fmt"
	"net"
)

func main() {
	listener, err := net.Listen("tcp", "127.0.0.1:8080")
	if err != nil {
		fmt.Println("net work listen error", err)
		return
	}
	defer listener.Close()

	fmt.Println("服务端等待客户端建立链接")
	con, err := listener.Accept()
	if err != nil {
		fmt.Println("listener Accept() error", err)
		return
	}
	defer con.Close()

	fmt.Println("服务器和客户端成功建立连接")
	buf := make([]byte, 4096)
	res, err := con.Read(buf)
	if err != nil {
		fmt.Println("con.Read() error", err)
		return
	}
	fmt.Println("success", string(res))

}
