class Solution {

    // Function to find the frequency of x in a sorted array
    public int frequency(int[] arr, int x) {

        int first = findCeil(arr, x);    // index of first occurrence
        int last  = findFloor(arr, x);   // index of last occurrence

        // If x does not exist in the array
        if (first == -1 || last == -1 || arr[first] != x || arr[last] != x) {
            return 0;
        }

        return last - first + 1;
    }

    // Floor: largest index such that arr[index] <= x
    private int findFloor(int[] arr, int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;          // possible floor
                low = mid + 1;      // try to find a larger one
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Ceil: smallest index such that arr[index] >= x
    private int findCeil(int[] arr, int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;          // possible ceil
                high = mid - 1;     // try to find a smaller one
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*
================================================
INTUITION
================================================
In a sorted array, all occurrences of a value x
appear in a contiguous block.

- The first occurrence of x is equal to ceil(x)
- The last occurrence of x is equal to floor(x)

Once we know both indices:
frequency = lastIndex - firstIndex + 1


================================================
PROBLEM EXPLANATION
================================================
Given a sorted array arr[] and an integer x,
find how many times x appears in the array.

If x does not exist, return 0.


================================================
WHY FLOOR + CEIL WORKS
================================================
ceil(x):
- Finds the smallest index i such that arr[i] >= x
- If x exists, this must be the first occurrence

floor(x):
- Finds the largest index j such that arr[j] <= x
- If x exists, this must be the last occurrence

Sorted order guarantees correctness.


================================================
DRY RUN
================================================
arr = [1, 2, 2, 2, 3, 4]
x = 2

findCeil(2)  -> index 1
findFloor(2) -> index 3

frequency = 3 - 1 + 1 = 3


================================================
EDGE CASES
================================================
1) x not present
   arr = [1, 2, 3, 4], x = 5
   → return 0

2) All elements same
   arr = [2, 2, 2, 2], x = 2
   → frequency = 4

3) Single element
   arr = [5], x = 5 → 1
   arr = [5], x = 3 → 0

4) x smaller than all elements
   arr = [3, 4, 5], x = 1
   → return 0


================================================
TIME AND SPACE COMPLEXITY
================================================
Time Complexity: O(log n)
(two binary searches)

Space Complexity: O(1)
(no extra space used)
*/
