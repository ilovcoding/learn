/// 接口隔离原则

import { log } from 'util';

interface Interface1 {
  operation1(): void;
  operation2(): void;
  operation3(): void;
}
class B implements Interface1 {
  public operation1(): void {
    log('B实现了接口1')
  }
  public operation2(): void {
    log('B实现了接口2')
  }
  public operation3(): void {
    log('B实现了接口3')
  }
}

class D implements Interface1 {
  public operation1(): void {
    log('D实现了接口1')
  }
  public operation2(): void {
    log('D实现了接口2')
  }
  public operation3(): void {
    log('D实现了接口3')
  }
}

class A {
  public depend1(i: Interface1): void {
    i.operation1()
  }
  public depend2(i: Interface1): void {
    i.operation2()
  }
}
class C {
  public depend2(i: Interface1): void {
    i.operation2()
  }
  public depend3(i: Interface1): void {
    i.operation3()
  }
}

export default class Segregation {
  public static main(): void {
    let a = new A()
    a.depend1(new B()) //B实现了接口1
    a.depend2(new B()) // B实现了接口2
    let c = new C()
    c.depend2(new D()) // D实现了接口2
    c.depend3(new D()) // D实现了接口3
  }
}

/**
 * 可见上面的设计
 * 类A通过接口Interface1依赖类B,
 * 类C通过接口Interface1依赖类D
 * B和D必须去实现A,C他们不需要的方法。
 * 因为接口Interface1对于类A和类C不是最小接口
 * 拆分方案见同名文件2
 */