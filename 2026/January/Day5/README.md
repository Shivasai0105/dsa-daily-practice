Day 05 – Sliding Window, Greedy & Counting Techniques
Problems Solved

LC 1975 – Maximum Matrix Sum

LC 424 – Longest Repeating Character Replacement

Length of Longest Substring with Distinct Characters

Number of Segments with Small Sum

Shortest Subarray with Sum ≥ K

Spot the Sneaky Twins

Core Patterns Practiced

Greedy optimization using mathematical observation

Variable-size sliding window (maximization)

Variable-size sliding window (minimization)

Counting subarrays using window boundaries

Hashing for frequency and duplication detection

Detailed Problem Explanations
1️⃣ LC 1975 – Maximum Matrix Sum

Pattern: Greedy + Math Observation

Problem Insight:
Since we can flip signs, the best strategy is to maximize the sum of absolute values.
The only restriction comes from the parity of negative numbers.

Key Reasoning:

If the number of negative values is even, all can be made positive.

If it is odd, one element must remain negative.

To minimize loss, keep the element with the smallest absolute value negative.

Final Insight:

Maximize everything first, then fix parity with minimal penalty.

2️⃣ LC 424 – Longest Repeating Character Replacement

Pattern: Variable-Size Sliding Window (Maximization)

Problem Insight:
We want the longest substring that can be turned into repeating characters using at most k replacements.

Window Logic:

Track the frequency of characters in the window.

Let maxFreq be the count of the most frequent character.

The window is valid if:

window size − maxFreq ≤ k


Important Detail:
maxFreq is never decreased when shrinking the window — this keeps the solution O(n) and still correct.

Final Insight:

Focus on the dominant character, not exact distribution.

3️⃣ Longest Substring with Distinct Characters

Pattern: Variable-Size Sliding Window

Problem Insight:
We need the longest substring with no repeating characters.

Strategy:

Expand the window with the right pointer.

On duplicate detection, move the left pointer past the last occurrence.

Use a HashMap to track last seen indices.

Final Insight:

Never reset the window; always move left forward intelligently.

4️⃣ Number of Segments with Small Sum

Pattern: Sliding Window + Counting

Problem Insight:
Count all subarrays whose sum is less than or equal to a given limit.

Key Observation:
If a window [left … right] is valid, then all subarrays ending at right and starting from left to right are valid.

Number of valid subarrays added:

right − left + 1


Final Insight:

Count subarrays by fixing the end pointer.

5️⃣ Shortest Subarray with Sum ≥ K

Pattern: Sliding Window (Minimization)

Problem Insight:
Among all subarrays whose sum is at least k, find the minimum length.

Strategy:

Expand right pointer until sum ≥ k.

Shrink left pointer aggressively to minimize window size.

Update minimum length.

Final Insight:

For minimization problems, shrink as soon as the condition is satisfied.

6️⃣ Spot the Sneaky Twins

Pattern: Hashing / Frequency Counting

Problem Insight:
Identify elements that appear more than once.

Strategy:

Use a HashMap or HashSet to track frequency.

Detect duplicates efficiently in one pass.

Final Insight:

When order doesn’t matter, hashing is the fastest approach.

Pattern Summary Table
Problem	Pattern
LC 1975	Greedy + Math
LC 424	Variable-size sliding window (max)
Distinct Substring	Variable-size sliding window
Small Sum Segments	Sliding window + counting
Shortest Subarray ≥ K	Sliding window (min)
Sneaky Twins	Hashing
Complexity Overview
Metric	Result
Time Complexity	O(n) for all problems
Space Complexity	O(1) / O(n) depending on hashing
One-Line Takeaway

Day 5 focused on controlling constraints—either by mathematical reasoning or by dynamically adjusting window boundaries.