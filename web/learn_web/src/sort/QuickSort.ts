import testAray from "./TestArray"
import Sort from './Sort';
import { log } from 'util';

/// 快排
class QuickSort implements Sort {
  method(arr: number[]): number[] {
    function quickSort(arr: any[], left: number, right: number) {
      let l = left // 左索引
      let r = right // 右索引
      let pivot = arr[Math.floor((l + r) / 2)]

      while (l < r) {
        //中线 在左边找 到一个比中间值大的值
        while (arr[l] < pivot) {
          l += 1
        }
        // 在中线右边找 比中间值小到值
        while (arr[r] > pivot) {
          r -= 1
        }
        if (l >= r) {
          // 说明 左边都是比中值小的值 ，右边都是比中值大的值
          break;
        }
        // l<r的时候交换 索引 l,r 对应的值
        [arr[l], arr[r]] = [arr[r], arr[l]]

        if (arr[l] == pivot || arr[r] == pivot) {
          break;
        }
      }
      
      if (l == r) {
        l += 1
        r -= 1
      }

      if (left < r) {
        quickSort(arr, left, r)
      }
      if (right > l) {
        quickSort(arr, l, right)
      }
      return arr
    }
    return quickSort(arr, 0, arr.length - 1)
  }
  public main() {
    this.method(testAray)
  }
}

export default QuickSort
