import java.util.*;

/*
 * PROBLEM:
 * ------------------------------------------------------------
 * Given an integer array nums and an integer k,
 * return the total number of subarrays whose sum equals k.
 *
 * EXAMPLE:
 * nums = {1, 1, 1}
 * k = 2
 * Output = 2
 */

/*
 * INTUITION:
 * ------------------------------------------------------------
 * We use the Prefix Sum technique with a HashMap.
 *
 * Let prefixSum[i] = sum of elements from index 0 to i.
 *
 * If a subarray from index (j + 1) to i has sum = k, then:
 *
 * prefixSum[i] - prefixSum[j] = k
 * => prefixSum[j] = prefixSum[i] - k
 *
 * So, for every index i, we check how many times
 * (prefixSum - k) has occurred before.
 *
 * Each occurrence represents one valid subarray ending at i.
 *
 * Unlike "longest subarray" problems, here we store
 * FREQUENCIES of prefix sums, not indices.
 */

/*
 * WHY mp.put(0, 1) IS IMPORTANT:
 * ------------------------------------------------------------
 * It represents an "empty prefix" before the array starts.
 *
 * This allows us to correctly count subarrays that start
 * from index 0.
 *
 * Example:
 * nums = {1, 2}, k = 3
 *
 * prefixSum at index 1 = 3
 * prefixSum - k = 0
 *
 * Without (0 -> 1) in map, this valid subarray would be missed.
 */

/*
 * ALGORITHM:
 * ------------------------------------------------------------
 * 1. Initialize:
 *    - prefixSum = 0
 *    - count = 0
 *    - HashMap to store frequency of prefix sums
 *    - put (0, 1) into the map
 *
 * 2. Traverse the array:
 *    a. Add nums[i] to prefixSum
 *    b. If (prefixSum - k) exists in map:
 *       - add its frequency to count
 *    c. Update frequency of prefixSum in map
 *
 * 3. Return count
 */

/*
 * DRY RUN:
 * ------------------------------------------------------------
 * nums = {1, 1, 1}
 * k = 2
 *
 * Initial:
 * prefixSum = 0
 * map = {0=1}
 * count = 0
 *
 * i   nums[i]   prefixSum   prefixSum-k   map contains?   count
 * ----------------------------------------------------------------
 * 0     1          1            -1            No            0
 *       map: {0=1, 1=1}
 *
 * 1     1          2             0           Yes (freq=1)
 *       count += 1 → count = 1
 *       map: {0=1, 1=1, 2=1}
 *
 * 2     1          3             1           Yes (freq=1)
 *       count += 1 → count = 2
 *       map: {0=1, 1=1, 2=1, 3=1}
 *
 * Final Answer: count = 2
 *
 * Subarrays with sum = 2:
 * [1, 1] (indices 0 to 1)
 * [1, 1] (indices 1 to 2)
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
    public int subarraySum(int[] nums, int k) {

        int prefixSum = 0;
        int count = 0;

        // HashMap to store frequency of prefix sums
        Map<Integer, Integer> map = new HashMap<>();

        // Important: empty prefix
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            // Update prefix sum
            prefixSum += nums[i];

            // Count subarrays ending at i with sum k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Update frequency of current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
