package Day5;

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {

        // Map stores: prefixSum -> first index where it appeared
        Map<Integer, Integer> mp = new HashMap<>();

        int preSum = 0;     // running prefix sum
        int maxLen = 0;     // length of longest valid subarray

        // prefix sum 0 occurs before array starts
        // helps when subarray starts from index 0
        mp.put(0, -1);

        for(int i = 0; i < arr.length; i++){

            // update prefix sum
            preSum += arr[i];

            // check if there exists a prefix such that
            // currentPrefix - previousPrefix = k
            if(mp.containsKey(preSum - k)){

                // calculate length of subarray
                int len = i - mp.get(preSum - k);

                // update maximum length
                maxLen = Math.max(maxLen, len);
            }

            // store prefix sum only the FIRST time
            // because earlier index gives longer subarray
            if(!mp.containsKey(preSum)){
                mp.put(preSum, i);
            }
        }

        return maxLen;
    }
}
/* 1️⃣ Longest Subarray with Sum = k

This algorithm finds the maximum length subarray whose sum equals k.
It uses the prefix sum technique, where we keep adding elements to get the running sum of the array.
A HashMap stores the first index where each prefix sum appears.
If at index i the prefix sum is preSum, we check whether (preSum - k) exists in the map.
If it exists, it means a previous prefix sum allows the subarray between those indices to sum to k.
The length of that subarray is calculated as i - previousIndex.
We update the maxLen if this length is larger than the current maximum.
The map stores the prefix sum only the first time it appears because earlier indices give longer subarrays.
We also initialize the map with (0, -1) to handle subarrays that start from index 0.
The algorithm runs in O(n) time because we traverse the array once and use constant-time map operations.
 */