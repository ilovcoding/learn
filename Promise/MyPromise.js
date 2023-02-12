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
