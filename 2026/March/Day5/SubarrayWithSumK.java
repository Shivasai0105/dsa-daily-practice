package Day5;

import java.util.*;

class Solution {
    public int subarraySum(int[] arr, int k) {

        // Map stores: prefixSum -> frequency of occurrence
        Map<Integer, Integer> mp = new HashMap<>();

        int preSum = 0;   // running prefix sum
        int count = 0;    // total number of valid subarrays

        // prefix sum 0 occurs once before array starts
        mp.put(0, 1);

        for(int i = 0; i < arr.length; i++){

            // update prefix sum
            preSum += arr[i];

            // if (preSum - k) appeared before,
            // those many subarrays end at index i
            if(mp.containsKey(preSum - k)){
                count += mp.get(preSum - k);
            }

            // update frequency of current prefix sum
            mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
/* 2️⃣ Count of Subarrays with Sum = k

This algorithm counts how many subarrays have a sum equal to k.
It also uses the prefix sum method to maintain the cumulative sum while traversing the array.
A HashMap stores the frequency of each prefix sum encountered so far.
For every element, we update the running prefix sum.
Then we check if (preSum - k) exists in the map.
If it exists, it means there are previous prefix sums that form a subarray ending at the current index with sum k.
The number of such subarrays equals the frequency stored in the map, which is added to the count.
After this check, we update the map by increasing the frequency of the current prefix sum.
The map is initialized with (0,1) to count subarrays that start from index 0.
This solution also runs in O(n) time with O(n) extra space because each element is processed once.
 */