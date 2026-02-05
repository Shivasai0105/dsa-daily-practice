class Solution {

    /*
     PROBLEM:
     Find and return the integer square root of x.
     (i.e., return floor(sqrt(x)))

     OBSERVATION:
     - sqrt(x) is the largest integer k such that k*k <= x
     - If x >= 2, sqrt(x) will always be <= x/2
     - Virtual range: [0, x/2]

     APPROACH (Binary Search):
     - Use binary search to find the largest mid such that mid*mid <= x
     - Store the last valid mid as the answer
     - Use long to avoid overflow when squaring

     TIME COMPLEXITY: O(log x)
     SPACE COMPLEXITY: O(1)
     */

    public int mySqrt(int x) {

        // Edge case: sqrt(1) = 1
        if (x == 1) return 1;

        int low = 0, high = x / 2;
        int ans = 0;   // stores the best valid square root so far

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Use long to prevent integer overflow
            long sqr = (long) mid * mid;

            // If exact square root found
            if (sqr == x) {
                return mid;
            }

            // If mid^2 is too large, move left
            else if (sqr > x) {
                high = mid - 1;
            }

            // If mid^2 is smaller, store mid and move right
            else {
                ans = mid;
                low = mid + 1;
            }
        }

        // Final answer is the floor of sqrt(x)
        return ans;
    }

    /*
     DRY RUN:

     Input: x = 8

     low = 0, high = 4

     mid = 2
     2*2 = 4 < 8 → ans = 2, low = 3

     mid = 3
     3*3 = 9 > 8 → high = 2

     loop ends (low > high)

     return ans = 2

     Output: 2
     */

}
