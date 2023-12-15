package merge_sort;

import java.util.ArrayList;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        process(arr, 0, arr.length-1);
        return  arr;
    }

    // 递归
    // 请把 arr [L ... R] 排有序
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static int[] mergeSort2(int[] arr) {
        process2(arr);
        return  arr;
    }
    //    非递归方法
    public static void process2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 步长
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N){
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(M  + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // p1 或者 p2 一定有一个越界了。
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,5,7,3,9,2,6,43,768,54,9,16};
        toString(mergeSort(arr1));
        int[] arr2 = {1,5,7,3,9,2,6,8,11,27,15,15,13,15,6,1,3,17};
        toString(mergeSort2(arr2));
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.get(1);
    }

    public static void toString(int[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]+" ");
        }
        stringBuffer.append("]");
        System.out.println(stringBuffer.toString());
    }
}
