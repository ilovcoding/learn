
function MyBind(ctx, ...argus1){
    const fn = this;
    return function(...argus2){
        fn.call(ctx, ...argus1, ...argus2);
    }
}

function test(...argus){
    console.log("argus::", argus)
    console.log(this?.name)
}

let obj = {
    name: 111
}

Function.prototype.MyBind = MyBind;

const fun  = test.MyBind(obj, 1,2);
fun(3,4,5)



