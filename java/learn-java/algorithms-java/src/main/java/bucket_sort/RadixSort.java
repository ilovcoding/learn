package bucket_sort;

import java.util.Arrays;

public class RadixSort {
    public int[] countSort(int[] arr, int place) {
        if (arr.length < 2) {
            return arr;
        }
//        计算出数据中的最大值
        int max = getPlaceNumber(arr[0], place);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, getPlaceNumber(arr[i], place));
        }
//        使用中间数组统计每个数的个数
        int[] countSortBucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countSortBucket[getPlaceNumber(arr[i], place)]++;
        }

//     将 countSortBucket 中每一项和前一项求和
        for (int i = 1; i < countSortBucket.length; i++) {
            countSortBucket[i] = countSortBucket[i] + countSortBucket[i - 1];
        }
//        遍历原数组进行排序
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            // countSortBucket[arr[i]] 输出该数 包含他自己前面有多少个数, 对应数-1的位置一定是当前数
            ans[--countSortBucket[getPlaceNumber(arr[i], place)]] = arr[i];
        }
        return ans;
    }

    public int getPlaceNumber(int num, int place) {
//        取出一个数对应的位置的数，place = 1 取的是 num 的个位，10 是 百位，100 是千位 依次类推。
        return num / place % 10;
    }

    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int[] radixSort(int[] arr) {
        int max = getMax(arr);
        for (int place = 1; max / place > 0; place *= 10) {
          arr =  countSort(arr, place);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] data = {121, 432, 564, 23, 1, 45, 788};
        RadixSort rs = new RadixSort();
        int[] ans = rs.radixSort(data);
        System.out.println(Arrays.toString(ans));
    }

}
