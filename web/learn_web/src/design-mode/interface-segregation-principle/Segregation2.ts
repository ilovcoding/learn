import { log } from 'util';
/// 接口隔离原则

interface Interface1 {
  operation1(): void;
}
interface Interface2 {
  operation2(): void;
}
interface Interface3 {
  operation3(): void;
}

class B implements Interface1, Interface2 {
  public operation1(): void {
    log('B实现了接口1')
  }
  public operation2(): void {
    log('B实现了接口2')
  }
}

class D implements Interface2, Interface3 {
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
  public depend2(i: Interface2): void {
    i.operation2()
  }
}
class C {
  public depend2(i: Interface2): void {
    i.operation2()
  }
  public depend3(i: Interface3): void {
    i.operation3()
  }
}
export default class Segregation2 {
  public static main(): void {
    let a = new A()
    a.depend1(new B()) //B实现了接口1
    a.depend2(new B()) // B实现了接口2
    let c = new C()
    c.depend2(new D()) // D实现了接口2
    c.depend3(new D()) // D实现了接口3
  }
}
// B,D实现类的代码,比之前的少了,减少不必要的代码