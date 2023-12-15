/**
 * 可参考 p-imit https://github.com/sindresorhus/p-limit
 */

class PromistLimit {
  constructor(limit) {
    this.limit = limit;
    this.runing = 0;
    this.queue = [];
  }

  add = (fun, ...args) => {
   return new Promise((resolve) => {
      this.enQueue(fun, resolve, args);
    });
  };

  // 方法进入队列
  enQueue = (fun, resolve, ...args) => {
    this.queue.push(this.run.bind(undefined, fun, resolve, ...args));
    this.start();
  };

  start = async () => {
    // 可能获取到的 running 不准
    await Promise.resolve();
    if (this.runing < this.limit && this.queue.length > 0) {
      this.queue.shift()();
    }
  };

  next = () => {
    this.runing--;
    this.start();
  };

  run = async (fun, resolve, ...args) => {
    this.runing++;
    // const result = (async () => fun(...args))();
    try {
      const result = fun(...args)
      resolve(result)
      await result;
    } catch {}
    this.next();
  };
}

const limit = new PromistLimit(2);
function asyncFun(value, delay) {
  return new Promise((resolve) => {
    console.log("start " + value);
    setTimeout(() => resolve(value), delay);
  });
}

async function test() {

  const input = [
    limit.add(() => asyncFun("aaa", 2000)),
    limit.add(() => asyncFun("bbb", 3000)),
    limit.add(() => asyncFun("ccc", 1000)),
    limit.add(() => asyncFun("ccc", 1000)),
    limit.add(() => asyncFun("ccc", 1000)),
  ]
  const result = await Promise.all(input);
  console.log(result);
}

test();


import pLimit from 'p-limit';

async function testPlimit() {
  const limit = pLimit(2);

  const input = [
    limit(() => asyncFun("aaa", 2000)),
    limit(() => asyncFun("bbb", 3000)),
    limit(() => asyncFun("ccc", 1000)),
    limit(() => asyncFun("ccc", 1000)),
    limit(() => asyncFun("ccc", 1000)),
  ];
  const result = await Promise.all(input);
  console.log(result);
}

// testPlimit();
