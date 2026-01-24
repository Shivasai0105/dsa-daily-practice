/* 
📌 Problem Explanation

You are given a sorted array arr[] and a value x.

Floor of x is defined as:

The largest element in the array that is less than or equal to x

If no such element exists, return -1.

💡 Intuition (Binary Search Variation)

Binary search works because the array is sorted.

Key idea:

If arr[mid] > x, it cannot be the floor → move left

If arr[mid] <= x, it can be a floor, but there might be a larger valid one on the right

So:

Store mid as a temporary answer

Continue searching right side to maximize the floor value

This guarantees:

You end with the rightmost element ≤ x

🔍 Dry Run Example
Example
arr = [1, 2, 4, 6, 10]
x = 5

Step-by-step
low	high	mid	arr[mid]	Action	ans
0	4	2	4	≤ x → store, move right	2
3	4	3	6	> x → move left	2
3	2	—	—	loop ends	2
Result

Floor value index = 2

Floor value = 4

⚠️ Edge Cases

x smaller than all elements

arr = [5, 6, 7], x = 3
Output = -1


x greater than all elements

arr = [1, 2, 3], x = 10
Output = index of 3


x exactly matches an element

arr = [1, 2, 4, 6], x = 4
Output = index of 4


Single element array

arr = [5], x = 5 → 0
arr = [5], x = 3 → -1


Duplicate values

arr = [1, 2, 2, 2, 3], x = 2
Output = index of last 2

⏱️ Time & Space Complexity

Time Complexity: O(log n)

Binary search halves the array each iteration

Space Complexity: O(1)

Only constant extra variables used */

class Solution {
    // Function to find the floor of x in a sorted array.
    // Floor of x = greatest element <= x
    public static int solve(int[] arr, int x) {
        int ans = -1;                 // stores index of floor value
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) {
                // mid element is too large, move left
                high = mid - 1;
            } else {
                // arr[mid] <= x, possible floor
                ans = mid;
                low = mid + 1;        // try to find a larger valid floor
            }
        }
        return ans;
    }
}
