package merge_sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Leet code https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
class SmallSum {
    public void process(int L, int R, int[] nums, int[] res, int[] indexs) {
        if (L == R) {
            return;
        }
        int M = (L + R) >> 1;
        process(L, M, nums, res, indexs);
        process(M + 1, R, nums, res, indexs);
        merge(L, M, R, nums, res, indexs);
    }

    public void merge(int L, int M, int R, int[] nums, int[] res, int[] indexs) {
        int i = L;
        int j = M + 1;
        int start = 0;
        int[] helps = new int[R - L + 1];
        int[] count = new int[R - L + 1];
        // save indexs in temp
        int[] temp = new int[R-L+1];
        for(int t = 0;t<temp.length;t++){
            temp[t] = indexs[L+t];
        }
        while (i <= M && j <= R) {
            if (nums[i] > nums[j]) {
                indexs[L + start] = temp[j-L];
                count[start] = 0;
                helps[start] = nums[j++];
            } else {
                indexs[L + start] = temp[i-L];
                count[start] = j - M - 1;
                helps[start] = nums[i++];
            }
            start++;
        }
        while (i <= M) {
            indexs[L + start] = temp[i-L];
            helps[start] = nums[i++];
            count[start++] = j - M - 1;
        }
        while (j <= R) {
            indexs[L + start] = temp[j-L];
            helps[start] = nums[j++];
            count[start++] = 0;
        }

        for (start = 0; start < helps.length; start++) {
            nums[L + start] = helps[start];
            res[indexs[L + start]] = res[indexs[L + start]] + count[start];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length >= 2) {
            int[] indexs = new int[nums.length];
            // save origin data list index
            for (int i = 0; i < nums.length; i++) {
                indexs[i] = i;
            }
            process(0, nums.length - 1, nums, res, indexs);
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SmallSum smallSum = new SmallSum();
//        System.out.println(smallSum.countSmaller(new int[]{5, 2, 6, 1,1}));
        System.out.println(smallSum.countSmaller(new int[]{5, -1,1}));
    }
}