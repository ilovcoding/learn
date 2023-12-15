import { log } from 'util';

export default class OCP2 {
  public static main(): void {
    let graphiEditor = new GraphiEditor()
    graphiEditor.drawShape(new Rectangle())
    graphiEditor.drawShape(new Circle())
    graphiEditor.drawShape(new Triangle())
  }
}

class GraphiEditor {
  public drawShape(s: Shape): void {
    s.draw()
  }
}

abstract class Shape {
  abstract draw(): void;
}
class Rectangle extends Shape {
  public draw(): void {
    log('绘制矩形')
  }
}
class Circle extends Shape {
  public draw(): void {
    log('绘制圆形')
  }
}
// 现在扩展三角形
class Triangle extends Shape {
  public draw(): void {
    log('绘制三角形')
  }
}

