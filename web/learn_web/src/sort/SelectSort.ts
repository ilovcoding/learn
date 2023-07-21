import Sort from './Sort';
import testAray from './TestArray';

class SelectSort implements Sort {
  method(arr: number[]): number[] {
    for (let i = 0; i < arr.length; i++) {
      let min = arr[i], minIndex = i;
      for (let j = i + 1; j < arr.length; j++) {
        if (min > arr[j]) {
          // 每轮循环都获取到最小值
          min = arr[j]
          minIndex = j
        }
      }
      // 确定最小值之后 再进行交换
      arr[minIndex] = arr[i]
      arr[i] = min
    }
    return arr
    throw new Error("Method not implemented.");
  }
  main(): void {
    this.method(testAray)
    // console.log(this.method(testAray))
  }


}
export default SelectSort