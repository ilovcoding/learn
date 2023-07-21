import Sort from './Sort';
import testAray from './TestArray';
/**继续数组的 大顶堆、小顶堆 堆排序 */
class  HeapSortArray implements Sort{
  method(arr: number[]): number[] {
    let res:number[] = []
    
    function adjectHeap (arr:number[]):number[] {
      if(arr.length ==1){
        res.push(arr[0])
        return res
      }
      for(let i = Math.floor(arr.length/2) -1;i>=0; i--){
        let temp = arr[i]
          for(let k = 2*i+1;k<arr.length; k = k*2+1){
            if(k+1 < arr.length && arr[k]<arr[k+1]){
              k++
            }
            if(arr[k]>temp){
              arr[i] = arr[k]
              i = k
            }else{
              break
            }
          }
          arr[i] = temp
      }
      res.push(arr[0])
      arr.shift()
     return adjectHeap(arr)
    }
    adjectHeap(arr)
    return res
  }  
  main(): void {
    let res = this.method(testAray)
    // console.log(res)
  }
}

export default HeapSortArray