import Sort from './Sort';
import testAray from './TestArray';
class ShellSort2 implements Sort {
  method(arr: number[]): number[] {
    let offSet = Math.floor(arr.length / 2)
    while (offSet > 0) {
      // console.log('此轮offset为', offSet)
      for (let i = 0; i < arr.length - offSet; i++) {
        let min = arr[i], minIndex: number = i
        for (let j = i; j < arr.length; j += offSet) {
          // 修改查找方法 为 类选择排序
          //开始查找最小的index
          if (arr[j] < min) {
            min = arr[j]
            minIndex = j
          }
        }
        arr[minIndex] = arr[i]
        arr[i] = min
      }
      offSet = Math.floor(offSet / 2)
    }
    return arr
  }
  main(): void {
    this.method(testAray)
  }
}

export default ShellSort2