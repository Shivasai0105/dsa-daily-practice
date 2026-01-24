// User function Template for Java
class Solution {

    // Function to find the ceil of x in a sorted array.
    // Ceil of x = smallest element >= x
    public int findCeil(int[] arr, int x) {

        int ans = -1;                      // stores index of ceil element
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                // arr[mid] can be a ceil
                ans = mid;
                high = mid - 1;           // try to find smaller valid ceil on left
            } else {
                // arr[mid] < x, ceil must be on right
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*
========================
INTUITION
========================
The array is sorted, so binary search can be used.
The ceil of x is the smallest element that is greater than or equal to x.

Whenever we find an element >= x:
- It is a valid candidate for ceil
- But there might be a smaller valid element on the left
So we store the index and move left.

If element < x:
- It cannot be a ceil
- Move to the right half

At the end, ans contains the index of the smallest element >= x.


========================
PROBLEM EXPLANATION
========================
Given a sorted array arr[] and an integer x,
find the index of the ceil of x.

Ceil of x:
- The smallest element in arr[] such that element >= x
- If no such element exists, return -1


========================
DRY RUN (EXAMPLE)
========================
arr = [1, 2, 4, 6, 10]
x = 5

low = 0, high = 4

mid = 2 → arr[2] = 4 < 5
→ move right (low = 3)

mid = 3 → arr[3] = 6 >= 5
→ possible ceil, ans = 3
→ move left (high = 2)

loop ends

Result:
index = 3
value = 6


========================
EDGE CASES
========================
1) x smaller than all elements
   arr = [5, 6, 7], x = 3
   Output = index of 5 (0)

2) x greater than all elements
   arr = [1, 2, 3], x = 10
   Output = -1

3) x equals an element
   arr = [1, 2, 4, 6], x = 4
   Output = index of 4

4) Single element array
   arr = [5], x = 5 → 0
   arr = [5], x = 7 → -1

5) Duplicate elements
   arr = [2, 2, 2, 4], x = 2
   Output = index of first 2


========================
TIME AND SPACE COMPLEXITY
========================
Time Complexity: O(log n)
Space Complexity: O(1)
*/
