package bucket_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class BucketSort {
    public void process(float[] arr, int n) {
        if (n <= 0) {
            return;
        }
        ArrayList<Float>[] bucket = new ArrayList[n];
//        初始化桶
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<Float>();
        }
//        数据放入桶中
        for (int i = 0; i < n; i++) {
            // float 数据是*n 取整数，如果都是整数就是取余运算
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }
//        分桶进行排序
        for (int i = 0; i < n; i++) {
            if (!bucket[i].isEmpty()) {
                Collections.sort(bucket[i]);
            }
        }

//        收集每个桶中排好顺序的数据
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        float[] arr = {(float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
                (float) 0.51};
        bucketSort.process(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
