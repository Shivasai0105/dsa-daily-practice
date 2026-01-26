/*
========================================================
PROBLEM: Majority Element (LeetCode 169)
========================================================

Given an array nums[] of size n,
find the element that appears more than ⌊n / 2⌋ times.

IMPORTANT GUARANTEE:
- The majority element ALWAYS exists.

--------------------------------------------------------
ALGORITHM USED: Moore’s Voting Algorithm
--------------------------------------------------------

This algorithm works on the idea of "vote cancellation".

--------------------------------------------------------
KEY OBSERVATION
--------------------------------------------------------

If an element appears more than n/2 times:
- Even if all other elements cancel it out,
- It will still survive till the end.

Hence, we don't need extra space.

--------------------------------------------------------
VARIABLE MEANING
--------------------------------------------------------

res  → current candidate for majority element
count → balance counter (NOT actual frequency)

--------------------------------------------------------
ALGORITHM STEPS
--------------------------------------------------------

1) Initialize:
   - count = 0
   - res = 0

2) Traverse the array:
   - If count == 0 → pick current element as candidate
   - If current element == candidate → count++
   - Else → count--

3) Return candidate

--------------------------------------------------------
CODE
--------------------------------------------------------
*/

class Solution {

    public int majorityElement(int[] nums) {

        int count = 0;
        int res = 0;

        for (int i : nums) {

            // If no active candidate, choose current element
            if (count == 0) {
                res = i;
            }

            // Vote for or against the candidate
            if (i == res) {
                count++;
            } else {
                count--;
            }
        }

        // Guaranteed to be the majority element
        return res;
    }
}

/*
========================================================
DRY RUN (STEP-BY-STEP EXAMPLE)
========================================================

Input:
    nums = [2, 2, 1, 1, 1, 2, 2]

Initial:
    res = 0
    count = 0

--------------------------------------------------------
Element = 2
count == 0 → res = 2
2 == res → count++

res = 2, count = 1

--------------------------------------------------------
Element = 2
2 == res → count++

res = 2, count = 2

--------------------------------------------------------
Element = 1
1 != res → count--

res = 2, count = 1

--------------------------------------------------------
Element = 1
1 != res → count--

res = 2, count = 0

--------------------------------------------------------
Element = 1
count == 0 → res = 1
1 == res → count++

res = 1, count = 1

--------------------------------------------------------
Element = 2
2 != res → count--

res = 1, count = 0

--------------------------------------------------------
Element = 2
count == 0 → res = 2
2 == res → count++

res = 2, count = 1

--------------------------------------------------------
END OF LOOP

Final Answer:
    Majority Element = 2

========================================================
WHY THIS WORKS
========================================================

- Each non-majority element cancels one occurrence of the majority element
- Since majority appears more than n/2 times,
  it can never be fully cancelled
- The surviving candidate is guaranteed to be the majority

========================================================
TIME & SPACE COMPLEXITY
========================================================

Time Complexity:  O(n)
Space Complexity: O(1)

========================================================
COMMON MISTAKES
========================================================

❌ Thinking count stores frequency (it does NOT)
❌ Forgetting majority is guaranteed
❌ Adding a second pass unnecessarily
❌ Using hashmap when O(1) space is required

========================================================
END OF NOTES
========================================================
*/

