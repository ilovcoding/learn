// 单例模式第一种写法 
// 饿汉式
// 可能造成 内存浪费
class SingletonType1{
  private Singleton (){

  }
  private static instance:SingletonType1 = new SingletonType1() 
  public static getInstance():SingletonType1 {
    return this.instance;
  }
}

