
function MyNew(Constructor, ...argus){
    // 创建空对象
    let obj = {}
    // 改变 继承 原来 对象的方法
    obj.__proto__ = Constructor.prototype;
    // 改变 this 指向
    Constructor.call(obj, ...argus)
    return obj
}

function People(name, sex){
    this.name = name;
    this.sex = sex
}

People.prototype.test = ()=>{
    console.log("test")
}

const o1 = MyNew(People, 2, 3)
console.log(o1)
o1.test()





// test(obj)