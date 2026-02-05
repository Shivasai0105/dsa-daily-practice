class Solution {

    /*
     INTUITION:
     - A peak element is one that is strictly greater than its neighbors.
     - The problem guarantees nums[-1] = nums[n] = -∞ (virtual boundaries).
     - So a peak ALWAYS exists.

     KEY OBSERVATION (Binary Search Insight):
     - If nums[mid] < nums[mid - 1], then a peak MUST exist on the LEFT side.
     - If nums[mid] < nums[mid + 1], then a peak MUST exist on the RIGHT side.
     - Because the array cannot keep going down or up forever.
     */

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Base case: single element is always a peak
        if (n == 1) return 0;

        /*
         EDGE CASES:
         Check first and last elements separately to avoid out-of-bounds
         */
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        /*
         Binary Search Range:
         We already handled edges, so we safely search from index 1 to n-2
         */
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             PEAK CHECK:
             nums[mid] is greater than both neighbors
             */
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            /*
             If left neighbor is greater,
             then a peak must exist on the LEFT side
             */
            else if (nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            }

            /*
             Else right neighbor is greater,
             so peak lies on the RIGHT side
             */
            else {
                low = mid + 1;
            }
        }

        // This line is never reached because a peak always exists
        return -1;
    }
}


/* 
nums = [1, 2, 1, 3, 5, 6, 4]
Edge check → false
low = 1, high = 5

mid = 3 → nums[3]=3
nums[3] < nums[4] → move right

low = 4, high = 5
mid = 4 → nums[4]=5
nums[4] < nums[5] → move right

low = 5, high = 5
mid = 5 → nums[5]=6
nums[5] > nums[4] && nums[5] > nums[6]
→ peak found at index 5
“I use binary search by observing that if the slope goes down on one side, a peak must exist in that direction.”
A peak element is one that is greater than its immediate neighbors.

Since the array has virtual −∞ boundaries, a peak is guaranteed to exist.

If nums[mid] < nums[mid-1], a peak must lie on the left side.

Otherwise, if nums[mid] < nums[mid+1], the peak lies on the right side.

Using this observation, binary search finds a peak in O(log n) time.
*/