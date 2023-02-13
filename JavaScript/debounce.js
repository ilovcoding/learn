const debounce = (fun, time)=> {
    let oldTime = Date.now()
    let timer = null;
    return (...argus)=> {
        let newTime = Date.now()
        if(!timer) {
            timer =  setTimeout(()=>{   fun(...argus)  }, time)
        }
        if(newTime - oldTime >= time) {
            timer = null;
        }else {
            clearTimeout(timer)
            timer =  setTimeout(()=>{   fun(...argus)  }, time);
        }
        oldTime = newTime;
    }
}

const fun  = debounce((...parms)=>{ console.log({ date:  Date.now() / 1000 | 0, parms })}, 2000 )


console.log(Date.now() / 1000 | 0 );
fun(1,2,3)
setTimeout(() => {
    console.log(Date.now() / 1000 | 0 );
    fun(1,2,3)
    setTimeout(() => {
        console.log(Date.now() / 1000 | 0 );
        fun(1,2,3)
    }, 1000);
}, 1000);

