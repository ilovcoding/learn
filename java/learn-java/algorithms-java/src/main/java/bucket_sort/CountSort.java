package bucket_sort;

import java.util.Arrays;

public class CountSort {
    public int[] process(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
//        计算出数据中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
//        使用中间数组统计每个数的个数
        int[] countSortBucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countSortBucket[arr[i]]++;
        }
//        输出统计完的数组
        System.out.println(Arrays.toString(countSortBucket));
//     将 countSortBucket 中每一项和前一项求和
        for (int i = 1; i < countSortBucket.length; i++) {
            countSortBucket[i] = countSortBucket[i] + countSortBucket[i - 1];
        }
//        遍历原数组进行排序
        int[] ans = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//        为了保障数据的顺序即排序结果的稳定性应该从后往前遍历。
        for (int i = arr.length -1; i >= 0; i--) {
            // countSortBucket[arr[i]] 输出该数 包含他自己前面有多少个数, 对应数-1的位置一定是当前数
            ans[--countSortBucket[arr[i]]] = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSort countSort = new CountSort();
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] ans = countSort.process(arr);
//       输出最终排好序的结果
        System.out.println(Arrays.toString(ans));
    }
}
