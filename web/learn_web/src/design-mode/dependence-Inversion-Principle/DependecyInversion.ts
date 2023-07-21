export default class DependecyInVersion {
  public static main(): void {
    let person = new Person();
    person.receive(new Email())
  }
}

// 完成Persion 接收消息的功能
class Person {
  public receive(email: Email): void {
    console.log(email.getInfo())
  }
}
class Email {
  public getInfo(): string {
    return "电子邮件信息 Hello World"
  }
}
// 分析案例
// 简单,比较容易想到
// 如果我们还需要接收 微信 QQ 短信的 消息 不好扩展
// 解决思路 引入一个IReceiver 表示接收者，这样Person类
// 与接口IReceiver发生依赖。因为Email Wei新都属接收业务范围
// 他们各自实现IReceiver 接口就行，符合依赖倒转原则

