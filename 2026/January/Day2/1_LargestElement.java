// Problem: Largest Element in an Array
// Pattern: Array Traversal
// Time: O(n)
// Space: O(1)

class Solution {
    public int largest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
