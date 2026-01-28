import java.util.*;

/*
 * PROBLEM:
 * ------------------------------------------------------------
 * Find the length of the largest subarray with sum equal to 0.
 * The array may contain positive, negative, and zero values.
 *
 * EXAMPLE:
 * arr = {15, -2, 2, -8, 1, 7, 10, 23}
 * Output = 5
 */

/*
 * INTUITION:
 * ------------------------------------------------------------
 * We use the Prefix Sum technique.
 *
 * Let prefixSum[i] = sum of elements from index 0 to i.
 *
 * If the same prefix sum occurs at two indices i and j (i > j),
 * then the subarray from (j + 1) to i has sum = 0.
 *
 * Why?
 * prefixSum[i] - prefixSum[j] = 0
 *
 * To get the maximum length subarray, we store the FIRST
 * occurrence of every prefix sum.
 *
 * This approach works for:
 * ✔ positive numbers
 * ✔ negative numbers
 * ✔ zeros
 */

/*
 * ALGORITHM:
 * ------------------------------------------------------------
 * 1. Initialize:
 *    - prefixSum = 0
 *    - maxLen = 0
 *    - HashMap to store (prefixSum -> first index)
 *
 * 2. Traverse the array:
 *    a. Add arr[i] to prefixSum
 *    b. If prefixSum == 0:
 *       - update maxLen = i + 1
 *    c. If prefixSum already exists in map:
 *       - length = i - map.get(prefixSum)
 *       - update maxLen
 *    d. Else:
 *       - store prefixSum with index i
 *
 * 3. Return maxLen
 */

/*
 * DRY RUN:
 * ------------------------------------------------------------
 * arr = {15, -2, 2, -8, 1, 7, 10, 23}
 *
 * i   arr[i]   prefixSum   map contains?   maxLen
 * ------------------------------------------------
 * 0    15         15           No             0
 *       map: {15=0}
 *
 * 1    -2         13           No             0
 *       map: {15=0, 13=1}
 *
 * 2     2         15          Yes (idx=0)
 *       length = 2 - 0 = 2
 *       maxLen = 2
 *
 * 3    -8          7           No             2
 *       map: {15=0, 13=1, 7=3}
 *
 * 4     1          8           No             2
 *       map: {15=0, 13=1, 7=3, 8=4}
 *
 * 5     7         15          Yes (idx=0)
 *       length = 5 - 0 = 5
 *       maxLen = 5
 *
 * 6    10         25           No             5
 *       map: {..., 25=6}
 *
 * 7    23         48           No             5
 *
 * Final Answer: maxLen = 5
 *
 * Subarray with sum 0:
 * [-2, 2, -8, 1, 7]
 */

/*
 * TIME COMPLEXITY:
 * ------------------------------------------------------------
 * O(n)
 *
 * SPACE COMPLEXITY:
 * ------------------------------------------------------------
 * O(n)
 */

class Solution {
    int maxLength(int arr[]) {

        int prefixSum = 0;
        int maxLen = 0;

        // HashMap to store prefixSum and its FIRST occurrence index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // Update prefix sum
            prefixSum += arr[i];

            // Case 1: subarray from index 0 to i
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // Case 2: repeating prefix sum found
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // Store only the first occurrence
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
