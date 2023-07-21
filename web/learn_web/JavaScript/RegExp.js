let regexp = /\B(?=(\d{3})+$)/g

console.log("12345678".replace(regexp, ","))


var str = 'x-x_';
var retArr = [];
str.replace(/(x_*)|(-)/g, function(match, p1, p2) {
    console.log({p1, p2, match})
  if (p1) { retArr.push({ on: true, length: p1.length }); }
  if (p2) { retArr.push({ on: false, length: 1 }); }
});

console.log(retArr);

// https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String/replace