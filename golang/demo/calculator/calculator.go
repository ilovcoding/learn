package calculator

type Opt struct {
	num1 int
	num2 int
}

type AddOpt struct {
	Opt
}

type SubOpt struct {
	Opt
}

func (s *SubOpt) SubOpt() int {
	return s.num1 - s.num2
}

func (a *AddOpt) Operate() int {
	return a.num1 + a.num2
}
