import Sort from './Sort';
import testAray from './TestArray';
class MergeSort implements Sort {
  merge(arr: number[], left: number, mid: number, right: number, temp: number[]) {
    let l = left //左边初始序列所有
    let r = mid + 1 // 右边初始序列索引
    let t = 0 //指向temp数组的索引
    while (l <= mid && r <= right) {
      if (arr[l] <= arr[r]) {
        temp[t] = arr[l]
        t++
        l++
      } else {
        temp[t] = arr[r]
        t++
        r++
      }
    }
    //说明左边还有剩余
    while (l <= mid) {
      temp[t] = arr[l]
      t++
      l++
    }
    while (r <= right) {
      temp[t] = arr[r]
      t++
      r++
    }
    t = 0
    let tempLeft = left
    while (tempLeft <= right) {
      arr[tempLeft] = temp[t]
      t += 1
      tempLeft += 1
    }
  }
  method(arr: number[]): number[] {
    let that = this
    function mergeSort(arr: number[], left: number, right: number, temp: number[]) {
      if (left < right) {
        let mid = Math.floor((left + right) / 2)
        mergeSort(arr, left, mid, temp)
        mergeSort(arr, mid + 1, right, temp)
        that.merge(arr, left, mid, right, temp)
      }
    }
    let temp = new Array(arr.length - 1)
    mergeSort(arr, 0, arr.length - 1, temp)
    return arr
  }
  main(): void {
    // console.log(this.method(testAray))
    this.method(testAray)
    // throw new Error("Method not implemented.");
  }


}
export default MergeSort