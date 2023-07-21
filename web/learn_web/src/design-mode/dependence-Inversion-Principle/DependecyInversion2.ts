import { log } from 'util';
export default class DependecyInVersion2 {
  public static main(): void {
    let person = new Person();
    person.receive(new Email())
    person.receive(new QQ())
  }
}

// 定义接收接口
interface IReceiver {
  getInfo(): string;
}
// 定义Email消息
class Email implements IReceiver {
  public getInfo(): string {
    return '接收到 Email消息'
  }
}
// 定义QQ消息
class QQ implements IReceiver {
  public getInfo(): string {
    return '接收到 QQ消息'
  }
}

// 完成Persion 接收消息的功能,
// 无论上层增加接收什么类型的消息,Persion类无需改变
class Person {
  public receive(receiver: IReceiver): void {
    log(receiver.getInfo())
  }
}

