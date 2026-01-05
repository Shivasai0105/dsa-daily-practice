Day 04 – Sliding Window & Dynamic Programming
Problems Solved

LC 1411 – Number of Ways to Paint N × 3 Grid

LC 3 – Longest Substring Without Repeating Characters

LC 567 – Permutation in String

Concepts Covered

Dynamic Programming with state compression

Variable-size sliding window

Fixed-size sliding window

Frequency counting using hash maps

Problem-wise Notes
1️⃣ LC 1411 – Number of Ways to Paint N × 3 Grid

Pattern: Dynamic Programming (State Compression)

Each row can be painted in only two valid patterns:

Type A (abc): all three cells different

Type B (aba): first and third same, middle different

Instead of tracking colors, we track counts of pattern types

Transition depends on how many valid colorings can follow from previous row

Key Insight:
A seemingly complex grid coloring problem can be reduced to constant DP states.

2️⃣ LC 3 – Longest Substring Without Repeating Characters

Pattern: Variable-Size Sliding Window

Window expands with the right pointer

On encountering a duplicate character:

Move left pointer to lastIndex + 1

HashMap stores the last seen index of characters

Key Insight:
Never reset the window; always move the left pointer forward intelligently.

3️⃣ LC 567 – Permutation in String

Pattern: Fixed-Size Sliding Window

Any permutation has the same character frequencies

Window size is fixed = length of s1

Slide the window over s2 and compare frequency maps

Key Insight:
Permutation detection reduces to frequency equality in a fixed-size window.

Pattern Recognition Summary
Problem	Pattern
LC 1411	Dynamic Programming (compressed states)
LC 3	Variable-size sliding window
LC 567	Fixed-size sliding window
Common Mistakes Avoided

Avoided brute-force substring checks

Avoided recalculating window state

Used optimal O(n) or O(1) space approaches

Properly handled window boundaries and transitions

Complexity Overview
Problem	Time	Space
LC 1411	O(n)	O(1)
LC 3	O(n)	O(n)
LC 567	O(n)	O(1)
One-Line Takeaway

Day 4 strengthened understanding of when to expand, when to shrink, and when to compress state.