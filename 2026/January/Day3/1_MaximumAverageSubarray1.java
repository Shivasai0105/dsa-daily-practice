class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int windowSum =0;
        for(int i=0;i<k;i++){
            windowSum += nums[i];
        }
        int maxWindSum = windowSum;
        for(int i=k;i<n;i++){
            windowSum += nums[i];
            windowSum -= nums[i-k];
            maxWindSum = Math.max(windowSum,maxWindSum);
        }
        return maxWindSum/(double)k;
    }
}

// ---

// ## 🧠 LC 643 – Maximum Average Subarray I

// **Pattern: Fixed-Size Sliding Window**

// ### Problem Intent

// Find the **maximum average** among all contiguous subarrays of **fixed length `k`**.

// ---

// ### Why Fixed-Size Sliding Window Applies

// * Subarray size is **explicitly fixed (`k`)**
// * All candidate subarrays overlap
// * Recomputing sum for each window would be wasteful (`O(nk)`)

// Sliding window reduces this to **O(n)**.

// ---

// ### Window Definition

// * **Window size**: `k`
// * **Window range**: `[i - k + 1 … i]`
// * Window slides **one step at a time**

// ---

// ### State Maintained Inside Window

// * `windowSum` → sum of current window
// * `maxWindSum` → maximum sum seen so far

// Only these two values are required.

// ---

// ### Window Initialization (first window)

// * Compute sum of the **first `k` elements**
// * This becomes both:

//   * the current window sum
//   * the initial maximum

// This avoids conditional checks later.

// ---

// ### Window Transition Logic

// For each new index `i`:

// * **Add** incoming element → `nums[i]`
// * **Remove** outgoing element → `nums[i - k]`
// * Update maximum window sum

// This keeps updates **O(1)** per step.

// ---

// ### Final Computation

// * Maximum **sum** is converted to **average**
// * Division is done **once**, at the end
// * Cast to `double` to avoid integer division

// ---

// ### Common Mistakes to Avoid

// * Recomputing sum for every window
// * Dividing inside the loop
// * Forgetting to initialize the first window
// * Returning integer division result

// ---

// ### Key Insight (One-liner)

// > When window size is fixed, **track the sum, not the average**, and slide efficiently.

// ---

// ### Complexity

// * **Time**: `O(n)`
// * **Space**: `O(1)`

// ---

// ### Suitable Header Comment (Paste Above Code)

// ```java
// // LeetCode 643
// // Pattern: Fixed-Size Sliding Window
// // Time: O(n)
// // Space: O(1)
// // Key Insight: Track window sum and slide by adding one element and removing one
// ```

// ---

