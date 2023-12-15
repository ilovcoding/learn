const PENDING = 'pending';
const REJECT = "rejected"
const FULFILL = "fulfilled"

// new Promise()

class MyPromise {
    constructor(exec){
        this.exec = exec;
        this.state = PENDING;
        this.value = void 0;
        this.reason = void 0;
        this.fullFilledCallback = []
        this.rejectedCallBack = []

        try {
            exec(this.resolve, this.rejected)
        } catch (error) {
            this.rejected(error)
        }
    }

    resolve = (value) => {
        if(this.state === PENDING){
            this.value = value;
            this.state = FULFILL;
        }
        this.fullFilledCallback.forEach(callback=> callback())
    }

    rejected = (resson) => {
        if(this.state === PENDING){
            this.reason = resson;
            this.state = REJECT;
        }
        this.rejectedCallBack.forEach(callback=> callback())
    }

    then=(onFullFiled, onRejected)=>{
        if(this.state === FULFILL){
            onFullFiled(this.value)
        }
        if(this.state === REJECT){
            onRejected(this.reason)
        }

        if(this.state === PENDING){
            this.fullFilledCallback.push(()=>{
                onFullFiled(this.value)
            })
            this.rejectedCallBack.push(()=>{
                onRejected(this.reason)
            })
        }
        return this;
    }

    catch = (fun)=>{
        this.then(null, fun)
    }
}

new MyPromise((resolve, reject)=>{
    setTimeout(()=>{
        resolve("Hello World")
    }, 3000)
}).then((res)=>{
    console.log(res)
}).then((res=>{
    console.log(res+2)
}))

/**
 * 复杂版本可看博客 
 * https://lemonlife.top/2020/02/10/interview/#%E4%BB%8B%E7%BB%8D%E4%B8%80%E4%B8%8Bpromise%E4%BB%A5%E5%8F%8A%E5%86%85%E9%83%A8%E7%9A%84%E5%AE%9E%E7%8E%B0
 */