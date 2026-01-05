class Solution {
    public int minimumRecolors(String s, int k) {
        int n = s.length();
        int ops = 0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='W'){
                ops++;
            }
        }
        int minops = ops;
        for(int i=k;i<n;i++){
            if(s.charAt(i)=='W'){
                ops++;

            }
            if(s.charAt(i-k)=='W'){
                ops--;
            }
            minops = Math.min(ops,minops);

        }
        return minops;
    }
}
/*
🧠 LC 2379 – Minimum Recolors to Get K Consecutive Black Blocks

Pattern: Fixed-Size Sliding Window

Problem Intent

Find the minimum number of recolors needed so that there exists a substring of length k containing only black ('B') blocks.

Recoloring a 'W' → 'B' costs 1 operation.

Why Fixed-Size Sliding Window Applies

We are checking all substrings of exact length k

Each window is independent but overlapping

Goal is to minimize a value across all windows

This fits perfectly into fixed-size sliding window.

Window Definition

Window size: k

Window range: [i - k + 1 … i]

Each window represents a candidate block of length k

State Maintained Inside Window

ops → number of 'W' characters in the current window
(each 'W' needs one recolor)

minops → minimum recolors seen so far

Window Initialization

Count 'W' characters in the first k characters

This gives the initial recolor cost

Initialize minops with this value

Ensures the first window is considered.

Window Transition Logic

For each index i from k to n - 1:

Add the new character s.charAt(i)

If it is 'W', increment ops

Remove the outgoing character s.charAt(i - k)

If it is 'W', decrement ops

Update minimum recolors

Each update is O(1).

Common Mistakes to Avoid

Recounting 'W' for every window

Using nested loops

Forgetting to remove the outgoing character

Misinterpreting 'W' count as 'B' count

Key Insight (One-liner)

In a fixed-size window, the number of recolors equals the count of bad characters ('W').

Complexity

Time: O(n)

Space: O(1)

Interview-Ready Header Comment
// LeetCode 2379
// Pattern: Fixed-Size Sliding Window
// Time: O(n)
// Space: O(1)
// Key Insight: Count 'W' characters in each window as recolor operations

🔥 FINAL MASTER NOTE — Fixed-Size Sliding Window (Revise This)
When to Use

Subarray / substring size is explicitly fixed

Need min / max / count / average over all such windows

Generic Template
// build first window
for (int i = 0; i < k; i++) updateState(i);

// slide window
for (int i = k; i < n; i++) {
    add(i);
    remove(i - k);
    updateAnswer();
}

Core Principle

Add one element, remove one element, update answer.

If you find yourself recalculating the whole window → you’re doing it wrong.

*/