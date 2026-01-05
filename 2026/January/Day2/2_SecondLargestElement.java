// Problem: Second Largest Element in an Array
// Pattern: Single Pass Tracking
// Time: O(n)
// Space: O(1)

class Solution {
    public int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num < largest && num > second) {
                second = num;
            }
        }

        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
