class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count =0;
        int n = arr.length;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        if((sum/k)>=threshold){
            count +=1;
        }
        
        for(int i=k;i<n;i++){
            sum += arr[i];
            sum -= arr[i-k];
            if((sum/k)>=threshold){
                count++;
            }
        }
        return count;
    }
}

/*
🧠 LC 1343 – Number of Subarrays of Size K and Average ≥ Threshold

Pattern: Fixed-Size Sliding Window

Problem Intent

Count how many contiguous subarrays of exact length k have an average ≥ threshold.

Why Fixed-Size Sliding Window Applies

Subarray length is constant (k)

All windows overlap

Recomputing sum per window would be inefficient

Sliding window enables O(n) traversal.

Key Transformation (Important)

Instead of checking:

average ≥ threshold


we check:

sum ≥ threshold × k


This avoids floating-point division inside the loop and improves clarity.

(Your code uses division; logically correct, but multiplication is preferred in interviews.)

Window Definition

Window size: k

Window range: [i - k + 1 … i]

State Maintained Inside Window

sum → sum of current window

count → number of valid windows found

No extra data structures needed.

Window Initialization

Compute sum of the first k elements

Immediately check if it satisfies the condition

This ensures all windows are evaluated, including the first one.

Window Transition Logic

For each index i from k to n - 1:

Add incoming element → arr[i]

Remove outgoing element → arr[i - k]

Check condition and update count

Each step is O(1).

Common Mistakes to Avoid

Using nested loops (O(nk))

Forgetting to check the first window

Using floating-point comparisons unnecessarily

Resetting sum instead of sliding it

Key Insight (One-liner)

When window size is fixed, convert average checks into sum comparisons.

Complexity

Time: O(n)

Space: O(1)

Interview-Preferred Header Comment
// LeetCode 1343
// Pattern: Fixed-Size Sliding Window
// Time: O(n)
// Space: O(1)
// Key Insight: Compare sum >= threshold * k to avoid division
 */