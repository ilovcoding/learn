package share_mem

import (
	"sync"
	"testing"
	"time"
)

func TestShareMem(t *testing.T) {
	counter := 0
	for i := 0; i < 5000; i++ {
		go func() {
			counter++
		}()
	}
	time.Sleep(time.Second * 1)
	t.Logf("counter=%d", counter)
}

func TestShareMemSafe(t *testing.T) {
	var mut sync.Mutex
	counter := 0
	for i := 0; i < 5000; i++ {
		go func() {
			defer func() {
				mut.Unlock()
			}()
			mut.Lock()
			counter++
		}()
	}
	time.Sleep(time.Second * 1)
	t.Logf("counter=%d", counter)
}

func TestShareMemSafeWaitGroup(t *testing.T) {
	var mut sync.Mutex
	var wg sync.WaitGroup

	counter := 0
	for i := 0; i < 5000; i++ {
		wg.Add(1)
		go func() {
			defer func() {
				mut.Unlock()
			}()
			mut.Lock()
			counter++
			wg.Done()
		}()
	}
	wg.Wait()
	t.Logf("counter=%d", counter)
}
