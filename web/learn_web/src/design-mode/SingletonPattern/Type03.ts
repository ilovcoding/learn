// 单例模式第一种写法 
// 懒汉式
class Singleton{
  private static instance:Singleton;
  private single(){}
  // 据说 这种写法 在Java里面是线程不安全的 哈哈，我JS天然单线程。(至少Node.js 12以下都是的)
  // 解决办法 static后面加 synchronized
  // 效率比较低
  // 采用 volatile 可以解决 双重检查 可以解决，js就不折腾了
  public static getInstance():Singleton{
    if(this.instance === null){
      this.instance = new Singleton()
    }
    return this.instance;
  }
}


// 单例模式第一种写法 
// 懒汉式
// 静态内部类 也可以解决 线程安全 和实现懒加载
// 好吧 ts也没有静态内部类

// 枚举的写法

// ts 也没有
// java中 推荐使用 枚举 ,静态内部类，双重检查，恶汉式(单线程可以用)
/**
 * 单例模式保证了 系统内存中该类只存在一个对象，节省了系统资源，
 * 对于一些需要频繁创建销毁的对象，使 用单例模式可以提高系统性能
2) 当想实例化一个单例类的时候，
必须要记住使用相应的获取对象的方法，
而不是使用 new
3) 单例模式使用的场景：
需要频繁的进行创建和销毁的对象、
创建对象时耗时过多或耗费资源过多(即：重量级 对象)
，但又经常用到的对象、工具类对象、
频繁访问数据库或文件的对象(比如数据源、session 工厂等)
 * 
 */