import java.util.*;

/*
 * PROBLEM:
 * ------------------------------------------------------------
 * Count the number of subarrays whose XOR is equal to k.
 *
 * The array contains integers (non-negative).
 *
 * EXAMPLE:
 * arr = {4, 2, 2, 6, 4}
 * k = 6
 * Output = 4
 */

/*
 * INTUITION:
 * ------------------------------------------------------------
 * We use the Prefix XOR technique.
 *
 * Let prefixXor[i] = XOR of elements from index 0 to i.
 *
 * XOR property:
 * If XOR of subarray from (j + 1) to i is k, then:
 *
 * prefixXor[i] ^ prefixXor[j] = k
 * => prefixXor[j] = prefixXor[i] ^ k
 *
 * So, while iterating, if we have already seen
 * (prefixXor ^ k), then that many subarrays end at i
 * with XOR equal to k.
 *
 * We store frequencies of prefix XOR values in a HashMap.
 *
 * This approach works in O(n) time.
 */

/*
 * ALGORITHM:
 * ------------------------------------------------------------
 * 1. Initialize:
 *    - prefixXor = 0
 *    - count = 0
 *    - HashMap to store frequency of prefix XORs
 *
 * 2. Traverse the array:
 *    a. prefixXor ^= arr[i]
 *    b. If (prefixXor ^ k) exists in map:
 *       - add its frequency to count
 *    c. If prefixXor == k:
 *       - increment count
 *    d. Store/update prefixXor frequency in map
 *
 * 3. Return count
 */

/*
 * DRY RUN:
 * ------------------------------------------------------------
 * arr = {4, 2, 2, 6, 4}
 * k = 6
 *
 * i   arr[i]   prefixXor   prefixXor^k   map contains?   count
 * ----------------------------------------------------------------
 * 0     4         4           2              No            0
 *       map: {4=1}
 *
 * 1     2         6           0              No
 *       prefixXor == k → count = 1
 *       map: {4=1, 6=1}
 *
 * 2     2         4           2              No
 *       map: {4=2, 6=1}
 *
 * 3     6         2           4             Yes (freq=2)
 *       count += 2 → count = 3
 *       map: {4=2, 6=1, 2=1}
 *
 * 4     4         6           0              No
 *       prefixXor == k → count = 4
 *       map: {4=2, 6=2, 2=1}
 *
 * Final Answer: count = 4
 *
 * Subarrays with XOR = 6:
 * [4, 2]
 * [2, 2, 6]
 * [6]
 * [4, 2, 2, 6, 4]
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
    public long subarrayXor(int arr[], int k) {

        int prefixXor = 0;
        int count = 0;

        // HashMap to store frequency of prefix XORs
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // Update prefix XOR
            prefixXor ^= arr[i];

            // Case 1: subarray ending at i with XOR = k
            if (map.containsKey(prefixXor ^ k)) {
                count += map.get(prefixXor ^ k);
            }

            // Case 2: subarray from index 0 to i
            if (prefixXor == k) {
                count++;
            }

            // Store/update prefix XOR frequency
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
