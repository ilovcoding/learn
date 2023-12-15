// 简单工厂模式
interface Shape{
  // 定义一个表示形状的接口，里面有画的方法
  draw()
}
class Rectangle implements Shape{
  draw(){
    console.log('我画了一个矩形')
  }
}
class Squre implements Shape{
  draw(){
    console.log("我画了一个正方形")
  }
}

class Circle implements Shape{
  draw(){
    console.log("我画了一个圆形")
  }
}
// 定义一个工厂
class ShapeFactory {
  getShape(shapeType){
    if(shapeType === null){
      return null
    }
    if(shapeType === "CIRCLE"){
      return new Circle()
    }else if(shapeType === "RECTANGLE"){
      return new Rectangle()
    }else if(shapeType === "SQUARE"){
      return new Squre()
    }
  }
}

//使用层
function main(){
  let shapeFactory = new ShapeFactory()
  let circle = shapeFactory.getShape("CIRCLE")
  circle.draw() // 我画了一个圆形
}