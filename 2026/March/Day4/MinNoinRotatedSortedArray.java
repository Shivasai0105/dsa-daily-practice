package Day4;

public class MinNoinRotatedSortedArray {
    
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        // Hint 1:
        // After rotation, the array is divided into two sorted parts.
        // The minimum element is at the point where the sorted order breaks (pivot).
        // We can use Binary Search to find which half contains this pivot.

        while (l < r) {
            int mid = l + (r - l) / 2;

            // Hint 2:
            // Compare nums[mid] with nums[r].
            // If nums[mid] > nums[r], the minimum must be in the right half.
            // Otherwise, the minimum is at mid or in the left half.

            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // l will point to the minimum element
        return nums[l];
    }
}