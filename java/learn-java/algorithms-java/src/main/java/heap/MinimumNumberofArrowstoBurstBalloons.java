package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Properties;

public class MinimumNumberofArrowstoBurstBalloons {
    public static int process(int[][] points) {
        int ans = 0;
//       先将所有气球按左边的值从小到大排列
        Arrays.sort(points, ((o1, o2) -> {
//            不使用 o1[0] - 02[0] 是为了考虑上限
            if (o1[0] >= o2[0]) {
                return 1;
            } else {
                return -1;
            }
        }));
        System.out.println(Arrays.toString(points[0]));
        PriorityQueue heap = new PriorityQueue();
        for (int i = 0; i < points.length; i++) {
            int[] item = points[i];
            int left = item[0];
            int right = item[1];
            if (!heap.isEmpty() && (int) (heap.peek()) <= left) {
//                清空堆(引爆气球)  ans +1
                heap.clear();
                ans++;
            }
            heap.add(right);
        }
//        最后一次引爆堆中其他气球
        if (!heap.isEmpty()) {
            heap.clear();
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] photos = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int ans = process(photos);
        System.out.println(ans);
    }
}
