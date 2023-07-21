
function MyCall(ctx, ...argus){
    ctx.fn = this;
    ctx.fn(...argus)
    delete ctx.fn;
}

function test(...argus){
    console.log(argus)
    console.log(this?.name)
}

let obj = {
    name: 111
}

Function.prototype.MyCall = MyCall

test.MyCall(obj, 1,2,3);

// test(obj)