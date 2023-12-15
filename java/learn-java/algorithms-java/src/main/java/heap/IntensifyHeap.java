package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class IntensifyHeap<T> {
    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comparator;

    public IntensifyHeap(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
        this.comparator = comparator;
    }

    public void heapify(int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left;
            if (left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0) {
                largest = left + 1;
            }
//          当前元素和孩子比较大小
            largest = comparator.compare(heap.get(index), heap.get(largest)) < 0 ? index : largest;
            if (largest == index) {
                break;
            }
            swap(index, largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public void heapInsert(int index) {
//        当前节点小于父节点
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void remove(T obj) {
        T replace = heap.get(heapSize - 1);
        int index = indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if (obj != replace) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    // 调整 value 的位置
    public void resign(T value) {
        int valueIndex = indexMap.get(value);
        heapInsert(valueIndex);
        heapify(valueIndex, heapSize);
    }

    public void push(T value) {
        heap.add(value);
        indexMap.put(value, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        int end = heapSize - 1;
        swap(0, end);
        heap.remove(end);
        indexMap.remove(ans);
        heapify(0, --heapSize);
        return ans;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }
}
