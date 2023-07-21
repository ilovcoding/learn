package polym

import "fmt"

type USBer interface {
	Read()
	Write()
}

type USBDev struct {
	id    int
	name  string
	speed int
}

type Mobile struct {
	USBDev
	call string
}

type Upan struct {
	USBDev
}

func (m *Mobile) Read() {
	fmt.Printf("%S 读取数据 SPEED = %S", m.name, m.speed)
}
