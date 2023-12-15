package heap;

/**
 * Heap Class
 * - isFull
 * - push
 * - pop
 * - heapInsert
 * - heapify
 */
public class Heap {
    private int limit;
    private int[] heap;
    private int heapSize;

    public Heap(int limit) {
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    public void push(int element) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = element;
        heapInsert(heap, heapSize++);
    }

    public int pop() {
//        选出头节点
        int ans = heap[0];
//        头节点和尾节点交换，之后移除尾节点
        swap(heap, 0, --heapSize);
//        从头节点开始调整堆
        heapify(heap, 0, heapSize);
        return ans;
    }

    //    index 位置节点和父节点 (index-1)/2 位置比较大小
    public void heapInsert(int[] arr, int index) {
        if (index == 0) {
            return;
        }
        //            构造大根堆，如果父节点小于当前节点
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }

    //    index 节点和他的左右子节点比较大小
    public void heapify(int[] arr, int index, int heapSize) {
//        左子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            //        选出左右孩子中最大的节点
            int largest = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
//        当前节点和子节点的最大值比较大小选出更大的。
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                return;
            }
//        子节点大于当前节点，根据大根堆的特点，子节点和当前节点交换
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public int heapSize() {
        return heapSize;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
