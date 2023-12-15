async function time(second){
    console.log(second)
    await new Promise((resolve)=>{
        setTimeout(()=>{
            resolve()
        },second)
    })
}

async function test(){
    console.time("test1")
    await time(500)
    await time(501)
    await time(502)
    await time(503)
    await time(504)
    await time(505)
    await time(506)
    await time(507)
    await time(508)
    await time(509)
    await time(510)
    console.timeEnd("test1")
    console.time("test2")
    await  Promise.all([time(500),time(501),time(502),time(503),time(504),time(505),time(506),time(507),time(508),time(509),time(510)])
    console.timeEnd("test2")

}
test()
