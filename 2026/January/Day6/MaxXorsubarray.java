class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;

        // XOR of first window
        int currXor = 0;
        for (int i = 0; i < k; i++) {
            currXor ^= arr[i];
        }

        int maxXor = currXor;

        // Slide the window
        for (int i = k; i < n; i++) {
            currXor ^= arr[i - k]; // remove outgoing
            currXor ^= arr[i];     // add incoming
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
/*
Problem: Maximum Subarray XOR of Size K (GFG)

Problem Explanation:
Given an array and an integer k,
find the maximum XOR value of any subarray of size k.

Approach:
1. Compute XOR of the first k elements (initial window).
2. Slide the window:
   - Remove the outgoing element using XOR.
   - Add the incoming element using XOR.
3. Track the maximum XOR seen.

Why XOR Sliding Window Works:
- XOR is reversible:
  a ^ b ^ b = a
- Allows efficient window update in O(1).

Key Insight:
- Unlike sum, XOR does not accumulate — it toggles bits.

Time Complexity:
- O(n) → sliding window traversal

Space Complexity:
- O(1) → constant extra space
*/
