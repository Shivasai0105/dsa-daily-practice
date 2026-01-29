import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int longest =1;
        if(nums.length<=0){
            return 0;
        }
        Set<Integer> st = new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        for(int i:st){
            if(!st.contains(i-1)){
                int cnt =1;
                int x = i;
                while(st.contains(x+1)){
                    x = x+1;
                    cnt++;
                }
                longest = Math.max(cnt,longest);
            }
        }
        return longest;
    }
}

/*
==================== NOTES ====================

PROBLEM STATEMENT:
Given an unsorted array of integers nums,
return the length of the longest sequence of consecutive integers.
The sequence must be consecutive numbers (difference of 1),
and the order in the array does NOT matter.

------------------------------------------------

KEY OBSERVATION / INTUITION:

- Sorting the array would give consecutive numbers easily,
  but sorting costs O(n log n).
- We need an O(n) solution.
- Using a HashSet allows O(1) average-time lookups.

Core idea:
👉 Only start counting a sequence from a number
    that does NOT have a previous number (i - 1).

This avoids counting the same sequence multiple times.

------------------------------------------------

ALGORITHM (STEP-BY-STEP):

1️⃣ Insert all elements into a HashSet.
   - Removes duplicates
   - Enables O(1) lookup

2️⃣ Iterate through each element in the set:
   - If (i - 1) does NOT exist in the set,
     then i is the START of a consecutive sequence.

3️⃣ From this start, keep checking:
   - i + 1, i + 2, i + 3, ...
   - Count how long the sequence continues.

4️⃣ Update the maximum length found.

5️⃣ Return the maximum length.

------------------------------------------------

WHY THE CHECK `!st.contains(i - 1)` IS IMPORTANT:

Without this check:
- Every number would start counting a sequence
- Same sequence would be counted multiple times
- Time complexity would degrade to O(n²)

This condition ensures:
- Each sequence is counted exactly once
- Only the smallest element starts the count

------------------------------------------------

DRY RUN EXAMPLE:

Input:
nums = [100, 4, 200, 1, 3, 2]

Set:
{1, 2, 3, 4, 100, 200}

Iteration:
i = 1 → (0 not in set) → start sequence
    1 → 2 → 3 → 4
    length = 4

i = 2 → (1 exists) → skip
i = 3 → (2 exists) → skip
i = 4 → (3 exists) → skip
i = 100 → (99 not in set) → length = 1
i = 200 → (199 not in set) → length = 1

Longest = 4

Output:
4

------------------------------------------------

EDGE CASES:

1️⃣ Empty array:
Input: []
Output: 0

2️⃣ Single element:
Input: [7]
Output: 1

3️⃣ All duplicates:
Input: [2, 2, 2]
Output: 1

4️⃣ Negative numbers:
Input: [-2, -1, 0, 1]
Output: 4

------------------------------------------------

TIME & SPACE COMPLEXITY:

Time Complexity: O(n)
- Each element is processed at most once

Space Complexity: O(n)
- HashSet stores all elements

------------------------------------------------

ONE-LINE SUMMARY (INTERVIEW READY):

"Use a HashSet and only start counting from numbers
that do not have a predecessor to find the longest
consecutive sequence in O(n) time."

================================================
*/