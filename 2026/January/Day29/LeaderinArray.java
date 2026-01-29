import java.util.*;
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {

        ArrayList<Integer> ls = new ArrayList<>();
        int n = arr.length;

        // Edge case: empty array
        if (n == 0) {
            return ls;
        }

        // The last element is always a leader
        int runningMax = arr[n - 1];
        ls.add(runningMax);

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= runningMax) {
                runningMax = arr[i];
                ls.add(runningMax);
            }
        }

        // Reverse to maintain original order
        Collections.reverse(ls);
        return ls;
    }
}

/*
==================== NOTES ====================

PROBLEM STATEMENT:
Given an array of integers, find all the LEADERS in the array.
An element is called a leader if it is greater than or equal to
all the elements to its right side.
The rightmost element is always a leader.

------------------------------------------------

KEY OBSERVATION / INTUITION:

- Checking every element against all elements to its right would take O(n²).
- Instead, if we traverse from RIGHT to LEFT:
  - We can maintain the maximum element seen so far.
  - Any element greater than or equal to this maximum is a leader.

This reduces the time complexity to O(n).

------------------------------------------------

ALGORITHM (STEP-BY-STEP):

1️⃣ Initialize an empty list to store leaders.

2️⃣ The last element of the array is always a leader.
   - Store it as `runningMax`.
   - Add it to the list.

3️⃣ Traverse the array from right to left (index n-2 to 0):
   - If arr[i] >= runningMax:
       - Update runningMax = arr[i]
       - Add arr[i] to the list

4️⃣ Since leaders are collected from right to left,
   reverse the list to restore left-to-right order.

------------------------------------------------

DRY RUN EXAMPLE:

Input:
arr = [16, 17, 4, 3, 5, 2]

Initial:
runningMax = 2
leaders = [2]

i = 4 → arr[4] = 5 ≥ 2 → leader
leaders = [2, 5], runningMax = 5

i = 3 → arr[3] = 3 < 5 → skip

i = 2 → arr[2] = 4 < 5 → skip

i = 1 → arr[1] = 17 ≥ 5 → leader
leaders = [2, 5, 17], runningMax = 17

i = 0 → arr[0] = 16 < 17 → skip

Reverse leaders:
[17, 5, 2]

Output:
[17, 5, 2]

------------------------------------------------

EDGE CASES:

1️⃣ Single element:
Input: [10]
Output: [10]

2️⃣ All elements same:
Input: [5, 5, 5]
Output: [5, 5, 5]

3️⃣ Strictly increasing array:
Input: [1, 2, 3, 4]
Output: [4]

4️⃣ Strictly decreasing array:
Input: [4, 3, 2, 1]
Output: [4, 3, 2, 1]

------------------------------------------------

TIME & SPACE COMPLEXITY:

Time Complexity: O(n)
- Single traversal of the array

Space Complexity: O(n)
- Extra list used to store leaders

------------------------------------------------

ONE-LINE SUMMARY (INTERVIEW READY):

"Traverse from right to left while maintaining a running maximum;
any element greater than or equal to it is a leader."

================================================
*/