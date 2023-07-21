package main

import (
	"errors"
	"net"
	"os"
	"syscall"
)

func main() {
	listener, _ := net.Listen("0.0.0.0", "8001")

	ConvertListener(listener)
}

func ConvertListener(l net.Listener) (nl Listener, err error) {
	if tmp, ok := l.(Listener); ok {
		return tmp, nil
	}
	ln := &listener{}
	ln.ln = l
	ln.addr = l.Addr()
	err = ln.parseFD()
	if err != nil {
		return nil, err
	}
	return ln, syscall.SetNonblock(ln.fd, true)
}

var _ net.Listener = &listener{}

type listener struct {
	fd    int
	addr  net.Addr       // listener's local addr
	ln    net.Listener   // tcp|unix listener
	pconn net.PacketConn // udp listener
	file  *os.File
}

func (l listener) Accept() (net.Conn, error) {
	//TODO implement me
	panic("implement me")
}

func (l listener) Close() error {
	//TODO implement me
	panic("implement me")
}

func (l listener) Addr() net.Addr {
	//TODO implement me
	panic("implement me")
}

func (ln *listener) parseFD() (err error) {
	switch netln := ln.ln.(type) {
	case *net.TCPListener:
		ln.file, err = netln.File()
	case *net.UnixListener:
		ln.file, err = netln.File()
	default:
		return errors.New("listener type can't support")
	}
	if err != nil {
		return err
	}
	ln.fd = int(ln.file.Fd())
	return nil
}
