// LeetCode 283
// Problem: Move Zeros to End
// Pattern: Two Pointers (In-place)
// Time: O(n)
// Space: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
