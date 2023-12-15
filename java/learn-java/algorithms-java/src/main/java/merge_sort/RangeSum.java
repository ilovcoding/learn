package merge_sort;

public class RangeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, -1, 5, 6, 11};
        int[] prefixSumArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                prefixSumArray[i] =  nums[i];
            }else {
                prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
            }
        }
    }
}
