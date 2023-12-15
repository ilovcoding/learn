// class Person {
//     static _person = new Person()

//     sayHello(){
//         console.log('Hello World JavaScript')
//     }

//     static getPerson(){
//         return this._person
//     }
// }
// export default Person

// 定义类
class Point {
  x: number
  y: number
	constructor(x:number, y:number) {
		this.x = x
		this.y = y
	}
}
class ColorPoint extends Point {
  color: string
	constructor(x:number, y:number, color:string) {
		super(x, y)
		this.color = color
  }
  
  private static world = 'world'
  private hello = 'hello'
  public say(){
     console.log(this.hello)
   }
   public static time(){
     console.log(this.world)
     return Date.now()
   }
} 
// 定义人的接口，指定了名字，年龄，和爱好
interface Person {
  name:string,
  age:number,
  hobby:Array<string>,
  sayHobby():string
}

// 根据这个接口 定义一个类小明
class XiaoMing implements Person {
  name: string  
  age: number
  hobby: string[]
  constructor(name: string,age: number,hobby: string[]){
      this.name = name
      this.age = age
      this.hobby = hobby
  }
  sayHobby(): string {
    return `我喜欢,${this.hobby.join(',')}`
  }
}

let xiaoMing = new XiaoMing('xiaoming',18,['唱','跳','rap','*球'])