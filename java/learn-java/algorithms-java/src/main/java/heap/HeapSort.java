package heap;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;
        Heap heap = new Heap(heapSize);
//      自底向上构造大根堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heap.heapify(arr, i, heapSize);
        }
//        每次选取最大值移除到数组的末尾 然后 heap.size -- 直到最后一个数从小到大排序成功
        while (heapSize > 0) {
            System.out.println(Arrays.toString(arr));
            swap(arr, 0, --heapSize);
            heap.heapify(arr, 0, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {1, 12, 9, 5, 6, 10};
        heapSort(data);
    }
}
