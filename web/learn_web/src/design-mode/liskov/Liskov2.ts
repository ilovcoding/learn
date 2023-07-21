import { log } from 'util';
export default class Liskov2 {
  public static main() {
    let a = new A()
    log('11+3=' + a.fun1(11, 3)) // 14
    log('1+8=' + a.fun1(1, 8)) // 9
    let b = new B()
    //因为 B类不再集成A类 所以开发者不会以为fun1试加法函数了
    log('11-3=' + b.fun1(11, 3)) // 8
    log('1-8=' + b.fun1(1, 8)) // -7
    // 如果开发者 还要使用A类中的方法 可以采用fun3

  }
}
class Base {

}
class A extends Base {
  public fun1(a: number, b: number): number {
    return a + b;
  }
}
class B extends Base {
  // 如果B需要使用A中的方法，采用以下组合方式
  public a = new A()
  public fun1(a: number, b: number): number {
    return a - b;
  }
  public fun2(a: number, b: number): number {
    return this.fun1(a, b) + 9;
  }
  public fun3(a: number, b: number): number {
    return this.a.fun1(a, b);
  }
}