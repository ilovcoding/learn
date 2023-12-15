package string_test1

import "testing"

func TestString(t *testing.T) {
	var s string
	t.Log(s)
	s = "hello"
	t.Log(len(s))
	s = "\xE4\xBB\xA5"
	t.Log(s)
	t.Log(len(s))
	s = "中"
	c := []rune(s)
	t.Log(len(c))
	t.Logf("中的 Unicode %x", c[0])
	t.Logf("中 UTF8 %x", s)
}

func TestStringToRane(t *testing.T) {
	s := "中华人民共和国"
	for _, c := range s {
		t.Logf("%[1]c %[1]d  %[1]x", c)
	}
}
