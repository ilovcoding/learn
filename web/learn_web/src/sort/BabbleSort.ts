import Sort from './Sort';
import testAray from './TestArray';

class BabbleSort implements Sort {
  method(arr: number[]): number[] {
    for (let i = 0; i < arr.length; i++) {
      for (let j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          [arr[i], arr[j]] = [arr[j], arr[i]]
        }
      }
    }
    return arr
  }
  main(): void {
    this.method(testAray)
    // console.log(this.method(testAray))
  }

}
export default BabbleSort