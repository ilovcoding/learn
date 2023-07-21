import Sort from './Sort';
import testAray from './TestArray';
class InsertSort implements Sort {
  method(arr: number[]): number[] {
    let resArr = [arr[0]]
    for (let i = 1; i < arr.length; i++) {
      let insertIndex = 0
      while (insertIndex < resArr.length) {
        if (resArr[insertIndex] < arr[i]) {
          insertIndex++
        } else {
          break
        }
      }
      resArr.splice(insertIndex, 0, arr[i])
    }
    return resArr
  }
  main(): void {
    this.method(testAray)
    // console.log(this.method(testAray))
  }


}
export default InsertSort