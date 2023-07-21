const deepClone = (obj)=>{
    let newObj = {}
    for (let key of Reflect.ownKeys(obj)) {
        Reflect.defineProperty(newObj, key, Reflect.getOwnPropertyDescriptor(obj, key))
        if(Reflect.apply(Object.prototype.toString, obj[key], []) === "[object Object]") {
            Reflect.set(obj, key, deepClone(obj[key]))
        }        
    }
    return newObj
}

let a = { b: 1}
let c= deepClone(a)
console.log(c.b)
c.b = 3
console.log(c, a)