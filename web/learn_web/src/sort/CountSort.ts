/// 计数排序
import Sort from './Sort';
import testAray from './TestArray';

class CountSort implements Sort {
  findMinMax(arr: number[]): number[] {
    let minMax = [arr[0], arr[0]]
    for (let i = 0; i < arr.length; i++) {
      if (minMax[0] > arr[i]) minMax[0] = arr[i];
      if (minMax[1] < arr[i]) minMax[1] = arr[i];
    }
    return minMax
  }
  method(arr: number[]): number[] {
    let [min, max] = this.findMinMax(arr)
    // console.log(min, max)
    let countArr = new Array(max - min + 1)
    arr.map(value => {
      countArr[value - min] ? countArr[value - min] += 1 : countArr[value - min] = 1
    })
    arr = []
    countArr.map((value, index) => {
      while (value >= 1) {
        arr.push(min + index)
        value--
      }
    })
    // console.log(countArr)

    return arr
    // throw new Error("Method not implemented.");
  }
  main(): void {
    let res = this.method(testAray)
    // console.log(res)
    // throw new Error("Method not implemented.");
  }
}

export default CountSort