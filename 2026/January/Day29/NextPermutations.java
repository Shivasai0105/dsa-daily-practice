class Solution {

    // Utility method to swap two elements in the array
    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Reverses the array from index 'start' till the end
    public static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(start, end, arr);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        boolean found = false;

        // Step 1: Find the rightmost index 'i' such that arr[i] < arr[i+1]
        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] < arr[i + 1]) {

                // Step 2: Find the smallest element greater than arr[i] on the right
                for (int j = n - 1; j >= i + 1; j--) {
                    if (arr[j] > arr[i]) {
                        swap(i, j, arr);      // Step 3: Swap
                        reverse(arr, i + 1);  // Step 4: Reverse suffix
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }

        // Step 5: If no pivot found, array is the largest permutation
        if (!found) {
            reverse(arr, 0);
        }
    }
}

/*
==================== NOTES ====================

PROBLEM STATEMENT:
Given an array of integers representing a permutation,
rearrange the numbers into the next lexicographically greater permutation.
If no such permutation exists, rearrange it to the smallest possible order
(sorted in ascending order).

------------------------------------------------

KEY OBSERVATION / INTUITION:

Lexicographical order means:
- Change the array as LITTLE as possible
- The change should happen as far RIGHT as possible

So we try to:
1. Find a position where we can increase the value slightly
2. Make the remaining part as small as possible

------------------------------------------------

ALGORITHM (STEP-BY-STEP):

1️⃣ Find the PIVOT:
   - Traverse from right to left
   - Find the first index i such that:
        arr[i] < arr[i + 1]
   - This guarantees the smallest possible increase

2️⃣ Find the NEXT GREATER element:
   - From the right side of the array
   - Find the smallest element greater than arr[i]

3️⃣ Swap arr[i] with that element

4️⃣ Reverse the suffix (i + 1 to end):
   - Because the suffix is in descending order
   - Reversing gives the smallest arrangement

5️⃣ Edge Case:
   - If no such i exists, the array is fully descending
   - Reverse the whole array to get the smallest permutation

------------------------------------------------

DRY RUN EXAMPLE:

Input: [1, 3, 2]

Step 1: Find pivot
- i = 0 → 1 < 3 (pivot found)

Step 2: Find next greater element than 1
- From right: 2 > 1

Step 3: Swap
- [2, 3, 1]

Step 4: Reverse suffix (index 1 to end)
- [2, 1, 3]

Output: [2, 1, 3]

------------------------------------------------

EDGE CASE EXAMPLE:

Input: [3, 2, 1]

Step 1:
- No index i such that arr[i] < arr[i+1]
- Array is the maximum permutation

Step 2:
- Reverse entire array

Output: [1, 2, 3]

------------------------------------------------

TIME & SPACE COMPLEXITY:

Time Complexity: O(n)
- One backward traversal
- One forward traversal
- One reversal

Space Complexity: O(1)
- In-place operations only

------------------------------------------------

ONE-LINE SUMMARY (INTERVIEW GOLD):

"Find the rightmost increasing pair, swap with the next larger element,
and reverse the suffix to get the next lexicographical permutation."

================================================
*/