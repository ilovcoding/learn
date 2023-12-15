import { log } from 'util';
export default class OCP {

  public static main(): void {
    let graphiEditor = new GraphiEditor()
    graphiEditor.drawShape(new Rectangle())
    graphiEditor.drawShape(new Circle())
  }
}
// 用户绘图的类 (使用方)
class GraphiEditor {
  public drawShape(s: Shape): void {
    if (s.mType == 1) {
      log('绘制矩形')
    } else if (s.mType == 2) {
      log('绘制圆形')
    }
  }
}

// (提供方)
class Shape {
  public mType: number
  constructor(mType: number) {
    this.mType = mType
  }
}
class Rectangle extends Shape {
  constructor() {
    super(1) // mType = 1
  }
}
class Circle extends Shape {
  constructor() {
    super(2) // mType = 2
  }
}
// 新增画三角形的类
// 发现扩展改变比较大
// 把Shap 变成抽象类
