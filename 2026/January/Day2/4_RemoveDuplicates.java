// LeetCode 26
// Problem: Remove Duplicates from Sorted Array
// Pattern: Two Pointers
// Time: O(n)
// Space: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
