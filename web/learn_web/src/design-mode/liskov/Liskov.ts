import { log } from 'util';
export default class Liskov {
  public static main() {
    let a = new A()
    log('11+3=' + a.fun1(11, 3)) // 14
    log('1+8=' + a.fun1(1, 8)) // 9
    let b = new B()
    log('11+3=' + b.fun1(11, 3)) // 8
    log('1+8=' + b.fun1(1, 8)) // -7
    // 程序本身没错 但是 不符合开发者思维
  }
}
class A {
  public fun1(a: number, b: number): number {
    return a + b;
  }
}
class B extends A {
  public fun1(a: number, b: number): number {
    return a - b;
  }
  public fun2(a: number, b: number): number {
    return this.fun1(a, b) + 9;
  }
}