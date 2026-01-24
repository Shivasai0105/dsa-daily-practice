//leetcode 1877 minimize maximum pair sum

/* We have an array with an even number of integers and need to pair them all up. The goal is to find the pairing that makes the largest sum among all pairs as small as possible.

Key Insight: Instead of trying every possible pairing (which would be very slow), 
we can use a clever observation - sort the array and pair the smallest with the largest,
then the second smallest with the second largest, and so on. This way we "balance" out the pairs. */
import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        // return nums[0]+nums[nums.length-1];
        int l =0,r = nums.length-1;
        int maxSum = 0;
        while(l<r){
            maxSum = Math.max(maxSum,nums[l]+nums[r]);
            l++;
            r--;
        }
    return maxSum;
    }

}