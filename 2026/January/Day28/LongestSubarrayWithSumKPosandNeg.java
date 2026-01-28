import java.util.*;

/*
 * PROBLEM:
 * ------------------------------------------------------------
 * Find the length of the longest subarray whose sum is equal to k.
 * The array may contain positive, negative, and zero values.
 *
 * EXAMPLE:
 * arr = {1, -1, 5, -2, 3}
 * k = 3
 * Output = 4
 */

/*
 * INTUITION:
 * ------------------------------------------------------------
 * We use the Prefix Sum technique.
 *
 * Let prefixSum[i] = sum of elements from index 0 to i.
 *
 * If a subarray from index (j + 1) to i has sum = k, then:
 *
 * prefixSum[i] - prefixSum[j] = k
 * => prefixSum[j] = prefixSum[i] - k
 *
 * So, while iterating through the array, if we have already seen
 * (prefixSum - k), we can calculate the length of the subarray.
 *
 * To maximize the subarray length, we store the FIRST occurrence
 * of each prefix sum.
 *
 * This approach works for:
 * ✔ positive numbers
 * ✔ negative numbers
 * ✔ zeros
 */

/*
 * ALGORITHM:
 * ------------------------------------------------------------
 * 1. Initialize prefixSum = 0 and maxLen = 0.
 * 2. Create a HashMap to store (prefixSum -> first index).
 * 3. Traverse the array:
 *    a. Add current element to prefixSum.
 *    b. If prefixSum == k, update maxLen = i + 1.
 *    c. If (prefixSum - k) exists in map:
 *       - length = i - map.get(prefixSum - k)
 *       - update maxLen.
 *    d. Store prefixSum in map only if not already present.
 * 4. Return maxLen.
 */

/*
 * DRY RUN:
 * ------------------------------------------------------------
 * arr = {1, -1, 5, -2, 3}
 * k = 3
 *
 * i   arr[i]   prefixSum   prefixSum-k   map contains?   maxLen
 * ----------------------------------------------------------------
 * 0     1          1            -2            No            0
 *       map: {1=0}
 *
 * 1    -1          0            -3            No            0
 *       map: {1=0, 0=1}
 *
 * 2     5          5             2            No            0
 *       map: {1=0, 0=1, 5=2}
 *
 * 3    -2          3             0           Yes (idx=1)
 *       length = 3 - 1 = 2
 *       prefixSum == k → maxLen = 4
 *       map: {1=0, 0=1, 5=2, 3=3}
 *
 * 4     3          6             3           Yes (idx=3)
 *       length = 4 - 3 = 1
 *
 * Final Answer: maxLen = 4
 *
 * Subarray: [1, -1, 5, -2]
 */

public class LongestSubarrayWithSumKPosandNeg {

    public int longestSubarray(int[] arr, int k) {

        int prefixSum = 0;
        int maxLen = 0;

        // HashMap to store prefixSum and its FIRST occurrence index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // Add current element to prefix sum
            prefixSum += arr[i];

            // Case 1: subarray from index 0 to i
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Case 2: subarray ending at i with sum k
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, length);
            }

            // Store prefix sum only if it is not already present
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
