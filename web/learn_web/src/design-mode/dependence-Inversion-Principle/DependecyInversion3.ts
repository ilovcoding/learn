import { log } from 'util';


// 方式1 基于接口传递实现依赖

// interface Message {
//   info(receive: IReceiver): void
// }
// interface IReceiver {
//   getInfo(): void;
// }

// class MyMessage implements Message {
//   public info(receice: IReceiver) {
//     receice.getInfo()
//   }
// }
// class Receiver implements IReceiver {
//   getInfo(): void {
//     log("我接收到消息啦~~")
//   }
// }
// export default class DependecyInVersion3 {
//   public static main() {
//     let myMessage = new MyMessage()
//     let receiver = new Receiver()
//     myMessage.info(receiver)
//   }
// }


// 方式2 通过构造方法传递
interface Message {
  info(): void
}
interface IReceiver {
  getInfo(): void;
}

class MyMessage implements Message {
  public receiver!: IReceiver
  constructor(receiver: IReceiver) { //构造器
    this.receiver = receiver
  }
  public info() {
    this.receiver.getInfo()
  }
}
class Receiver implements IReceiver {
  getInfo(): void {
    log("我接收到消息啦~~")
  }
}
export default class DependecyInVersion3 {
  public static main() {
    let receiver = new Receiver()
    let myMessage = new MyMessage(receiver)
    myMessage.info()
  }
}

// 方案3 通过setter方法
// interface Message {
//   info(): void
//   setReceive(receive: IReceiver): void
// }
// interface IReceiver {
//   getInfo(): void;
// }

// class MyMessage implements Message {
//   public rceice!: IReceiver; // TS要求添加明确赋值断言
//   public setReceive(rec: IReceiver): void {
//     this.rceice = rec
//   }
//   public info() {
//     this.rceice.getInfo()
//   }
// }
// class Receiver implements IReceiver {
//   getInfo(): void {
//     log("我接收到消息啦~~")
//   }
// }
// export default class DependecyInVersion3 {
//   public static main() {
//     let myMessage = new MyMessage()
//     myMessage.setReceive(new Receiver())
//     myMessage.info()
//   }
// }
