package test;

import java.util.Arrays;

public class KthSmallPairDist {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];
        while(left < right){
            int mid = left + (right - left) / 2;
            if (isSmall(nums, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static boolean isSmall(int[] nums, int k, int mid){
        int count = 0;
        int left = 0;
        for (int i = 1;i < nums.length;i++){
            while(nums[i] - nums[left] > mid)
                left++;
            count+=i-left;
        }
        return count >=k;
    }
    public static void main(String[]args){
        int[]arr = {2, 4, 1, 3, 7, 6};
        int k = 3;
        System.out.println(smallestDistancePair(arr,k));
    }
}
