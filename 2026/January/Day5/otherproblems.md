Longest Substring with Distinct Characters

Pattern: Variable-Size Sliding Window

What the problem is really asking

Find the longest substring where no character repeats.

Sliding Window Logic

Expand right pointer

If duplicate appears:

Move left pointer just past the previous occurrence

Never move left backward

Why HashMap?

To store the last seen index of each character.

This allows:

left = max(left, lastSeenIndex + 1)

Why max() is critical

Without it, left could move backward, breaking the window.

Complexity Reasoning

Each character enters window once

Each character leaves window once
→ O(n)

Final Insight

Sliding window is about controlled shrinking, not restarting.

4️⃣ Number of Segments with Small Sum

Pattern: Sliding Window + Counting

What the problem is really asking

Count all subarrays where the sum is ≤ target.

Key Observation

If a window [left … right] has sum ≤ target, then:

All subarrays ending at right
and starting from left to right
are also valid


So number of valid subarrays ending at right is:

(right − left + 1)

Strategy

Expand right pointer

Shrink left pointer if sum exceeds target

Add (right - left + 1) to count

Why this works

Sliding window ensures:

Window always valid

All subarrays are counted without enumeration

Final Insight

Count subarrays by fixing the end, not the start.

5️⃣ Shortest Subarray with Sum ≥ K

Pattern: Sliding Window (Minimization)

What the problem is really asking

Among all subarrays whose sum ≥ k, find the shortest length.

Strategy

Expand right pointer to reach sum ≥ k

Once valid:

Shrink aggressively from left

Update minimum length

Why shrinking is aggressive

Because:

Any longer window is worse

Once condition is met, we want to minimize length

Important Difference from other window problems

Here, we:

Expand to satisfy

Shrink to optimize

Final Insight

For minimum problems, shrink as soon as possible.

6️⃣ Spot the Sneaky Twins

Pattern: Hashing / Frequency Counting

What the problem is really asking

Find elements that appear more than once (duplicates).

Strategy

Use a HashMap or HashSet

Track frequency or existence

Detect repeats efficiently

Why hashing?

Constant-time lookup

Avoid nested loops

Final Insight

When order doesn’t matter, hashing beats traversal.

🧠 Day 5 Pattern Summary (Mental Model)
Pattern	Core Question
Greedy	What must stay unchanged?
Sliding Window (max)	How far can I expand?
Sliding Window (min)	How fast can I shrink?
Hashing	Have I seen this before?
🔑 One Unified Takeaway

Day 5 is about controlling constraints — either by math (greedy) or by window boundaries (sliding window).