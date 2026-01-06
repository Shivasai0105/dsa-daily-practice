

# Day 6 – Mixed Practice (Two Pointers, BFS, Sliding Window, XOR)

## Problems Solved

1. **Valid Palindrome** (LeetCode 125)
2. **Robot Return to Origin** (LeetCode 657)
3. **Maximum Level Sum of a Binary Tree** (LeetCode – Daily Problem)
4. **Maximum Subarray XOR of Size K** (GFG – Daily Problem)

---

## Core Concepts Practiced

* Two-pointer technique
* String preprocessing
* Simulation
* Breadth-First Search (BFS)
* Fixed-size sliding window
* Bitwise XOR properties

---

## Problem-wise Explanation

---

### 1️⃣ Valid Palindrome

**Pattern: Two Pointers + String Preprocessing**

**What was done:**

* Converted string to lowercase
* Filtered only alphanumeric characters
* Used two pointers to check palindrome property

**Why this works:**

* Removing irrelevant characters simplifies the problem
* Two-pointer comparison is optimal for palindrome checks

**Time Complexity:** O(n)
**Space Complexity:** O(n) (filtered string)

**Key Insight:**

> Simplify input first, then apply a standard pattern.

---

### 2️⃣ Robot Return to Origin

**Pattern: Simulation**

**What was done:**

* Tracked `(x, y)` coordinates
* Updated position for each move
* Checked if final position is `(0,0)`

**Why this works:**

* The problem is a direct simulation with no hidden constraints

**Time Complexity:** O(n)
**Space Complexity:** O(1)

**Key Insight:**

> When state changes are simple, simulate directly.

---

### 3️⃣ Maximum Level Sum of a Binary Tree

**Pattern: BFS (Level Order Traversal)**

**What was done:**

* Used a queue to traverse the tree level by level
* Calculated sum of each level
* Tracked the level with maximum sum

**Why BFS:**

* Level-order traversal naturally groups nodes by depth
* Makes level-wise aggregation straightforward

**Time Complexity:** O(n)
**Space Complexity:** O(n)

**Key Insight:**

> BFS is the natural choice for level-based tree problems.

---

### 4️⃣ Maximum Subarray XOR of Size K

**Pattern: Fixed-Size Sliding Window + Bitwise XOR**

**What was done:**

* Calculated XOR of the first window
* Slid the window by removing outgoing and adding incoming elements using XOR
* Tracked maximum XOR value

**Why XOR works here:**

* XOR is reversible (`a ^ b ^ b = a`)
* Enables constant-time window updates

**Time Complexity:** O(n)
**Space Complexity:** O(1)

**Key Insight:**

> XOR behaves differently from sum but still supports sliding window logic.

---

## Pattern Summary

| Problem                | Pattern                         |
| ---------------------- | ------------------------------- |
| Valid Palindrome       | Two pointers                    |
| Robot Return to Origin | Simulation                      |
| Max Level Sum (Tree)   | BFS                             |
| Max Subarray XOR       | Fixed-size sliding window + XOR |

---

## Overall Takeaway

> Today focused on **reinforcing fundamentals** across multiple domains rather than deep-diving into a single pattern.

These problems strengthen:

* Input preprocessing
* Pointer movement logic
* Tree traversal confidence
* Sliding window adaptability beyond sums

---

