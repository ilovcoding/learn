// Quick sort in Java
package quick_sort;

import javax.swing.*;
import java.util.Arrays;

class QuickSort {

    /**
     * @param array 等待排序数组
     * @param L     数据左边界
     * @param R     数据又边界
     * @return 小于区域右边界和大于区域左边界
     */
    static int[] partition(int array[], int L, int R) {
//      小于区域右边界
        int pLR = L - 1;
//        大于区域左边界;
        int pGL = R;
//        选出用于比较大小的基准元素
        int pivot = array[R];
//       用于遍历数组比较大小
        int j = L;
//        遍历数组开始比较大小;
        while (j < pGL) {
            if (array[j] == pivot) {
//                相等: 小于区域和大于区域都不动 j++ 比较下一个
                j++;
            } else if (array[j] > pivot) {
//                大于: 小于区域不动 array[j] 和大于区域左边一个j交换,大于区左移
                swap(array, j, --pGL);
            } else {
//                小于: 大于区域不动 array[j] 和小于区域右边一个数进行交换小于区域右移动, j++ 继续比较下一个
                swap(array, ++pLR, j++);
            }

        }
//        pivot 和 大于区域最左边的数交换
        swap(array, pGL, R);
        System.out.println(Arrays.toString(array));
        return new int[]{pLR, pGL + 1};
    }

    /**
     * 把 array i 和 j 位置数据进行交换
     */
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void process(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
//      每次排序之前随机交换一个数到最右边，从概率学上优化
        int left = L + (int) (Math.random() * (R - L + 1));
        swap(array, left, R);
//      第一次排序 得到小于区域右边界和大于区域左边界
        int[] index = partition(array, L, R);
//      递归继续排序小于区域和大于区域
        process(array, L, index[0]);
        process(array, index[1], R);

    }

    static int[] quickSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        process(array, 0, array.length - 1);
        return array;
    }

    public static void main(String[] args) {
        int[] data = {8, 7, 2, 1, 0, 9, 2};
        quickSort(data);
    }

}
