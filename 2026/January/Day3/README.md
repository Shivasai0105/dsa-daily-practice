Day 03 – Fixed-Size Sliding Window (Array & String)
Problems Covered

LC 643 – Maximum Average Subarray I

LC 1343 – Number of Subarrays of Size K and Average ≥ Threshold

LC 2379 – Minimum Recolors to Get K Consecutive Black Blocks

All three problems use the fixed-size sliding window pattern.

What Is Fixed-Size Sliding Window?

Fixed-size sliding window is used when:

The subarray / substring length is explicitly fixed (k)

We must evaluate all contiguous windows of the same size

We want an optimal solution better than brute force

Instead of recomputing values for every window, we reuse work from the previous window.

Core Principle

Add one element, remove one element, update the answer.

Only two elements change when the window moves:

One element enters the window

One element leaves the window

Generic Template
// Step 1: build first window
for (int i = 0; i < k; i++) {
    updateState(arr[i]);
}

// Step 2: slide the window
for (int i = k; i < n; i++) {
    add(arr[i]);        // incoming element
    remove(arr[i - k]); // outgoing element
    updateAnswer();
}


This guarantees:

Time Complexity → O(n)

Space Complexity → O(1)

Problem-wise Insights
LC 643 – Maximum Average Subarray I

Window state: sum of elements

Track maximum sum, divide by k at the end

Do not compute average inside the loop

Insight:

Track sums, not averages.

LC 1343 – Number of Subarrays of Size K

Window state: sum of elements

Convert condition:
average ≥ threshold → sum ≥ threshold × k

Insight:

Replace division with multiplication to avoid floating-point errors.

LC 2379 – Minimum Recolors

Window state: count of 'W' characters

Each 'W' represents one recolor operation

Goal: minimize 'W' count across all windows

Insight:

Count “bad” elements instead of trying to build “good” ones.

Common Mistakes to Avoid

Recomputing window values every time

Forgetting to process the first window

Using nested loops

Using floating-point division unnecessarily

Sliding the window by more than one index

Pattern Recognition Checklist

Ask yourself:

Is the window size fixed?

Are all subarrays contiguous?

Does each new window differ by exactly one element?

If yes → fixed-size sliding window.

Complexity Summary
Metric	Value
Time	O(n)
Space	O(1)
One-Line Summary

Fixed-size sliding window optimizes repeated subarray calculations by updating state incrementally instead of recomputing from scratch.