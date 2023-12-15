package main

import "net"

type Listener interface {
	net.Listener

	// Fd return listener's fd, used by poll.
	Fd() (fd int)
}
