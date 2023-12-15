const throttle = (fun, time = 0)=> {
    let oldTime = Date.now();
    let timer = null;
    return (...argus)=>{
        let newTime = Date.now()
        if(!timer) {
            timer = setTimeout(()=>{fun(...argus)}, time)
        }
        if(newTime - oldTime > time) {
            timer = null;
            oldTime = newTime;
        }
    }
}

const fun  = throttle((...parms)=>{ console.log({ date:  Date.now() / 1000 | 0, parms })}, 2000 )

setInterval(() => {
    fun(1,2,3)
}, 10);

