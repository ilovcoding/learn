// 单例模式第一种写法 
// 饿汉式
// 经典代码块 好的吧  ts 没有静态代码块
class SingletonType2{
  private Singleton (){

  }

  private static instance:SingletonType2;

  instance = new SingletonType2() 
  public static getInstance():SingletonType2 {
    return this.instance;
  }
}

