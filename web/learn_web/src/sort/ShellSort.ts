import Sort from './Sort';
import testAray from './TestArray';
class ShellSort implements Sort {
  method(arr: number[]): number[] {
    let offSet = Math.floor(arr.length / 2)
    while (offSet > 0) {
      // console.log('此轮offset为', offSet)

      for (let i = 0; i <= arr.length - offSet; i++) {
        for (let j = i; j < arr.length - offSet; j += offSet) {
          if (arr[j] > arr[j + offSet]) {
            [arr[j], arr[j + offSet]] = [arr[j + offSet], arr[j]]
          }
        }
      }
      offSet = Math.floor(offSet / 2)
      // console.log(arr.toString())
    }
    return arr
    throw new Error("Method not implemented.");
  }
  main(): void {
    // console.log(this.method(testAray))
    this.method(testAray)

  }
}

export default ShellSort