/// 基数排序 桶排序
import Sort from './Sort';
import testAray from './TestArray';
class RadixSort implements Sort {
  method(arr: number[]): number[] {
    //定义10个装数的桶
    let bucket = new Array(10)
    for (let i = 0; i < 10; i++) {
      bucket[i] = []
    }
    // 取出个位数做 放入桶中
    arr = arr.filter(value => { bucket[value % 10].push(value) })
    bucket.map((value) => {
      while (value.length > 0) {
        arr.push(value.shift())
      }
    })
    // 取出 10位数 放桶中
    arr = arr.filter(value => { bucket[Math.floor((value / 10)) % 10].push(value) })
    bucket.map((value) => {
      while (value.length > 0) {
        arr.push(value.shift())
      }
    })
    // 取出百位数 放入桶中
    arr = arr.filter(value => { bucket[Math.floor((value / 100)) % 10].push(value) })
    bucket.map((value) => {
      while (value.length > 0) {
        arr.push(value.shift())
      }
    })
    return arr
  }
  main(): void {
    let res = this.method(testAray)
  }
}
export default RadixSort