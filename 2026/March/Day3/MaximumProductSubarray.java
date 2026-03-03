package Day3;

public class MaximumProductSubarray {
    


    /*
     * PROBLEM: Maximum Product Subarray
     *
     * GOAL:
     * Find the maximum product of a contiguous subarray.
     *
     * CORE DIFFICULTY:
     * 1) Negative numbers flip sign.
     * 2) Zero breaks product continuity.
     *
     * KEY OBSERVATION:
     * If a subarray has:
     * - Even number of negatives → full product is positive.
     * - Odd number of negatives → we must drop either:
     *      - prefix up to first negative
     *      - suffix after last negative
     *
     * Instead of explicitly counting negatives,
     * we scan from BOTH directions.
     *
     * Why both?
     * Because:
     * - Left-to-right captures cases where dropping prefix helps.
     * - Right-to-left captures cases where dropping suffix helps.
     *
     * Zero handling:
     * When product becomes 0, it splits the array.
     * We reset product to 1 to start a fresh subarray.
     */

    public int maxProduct(int[] nums) {

        int n = nums.length;

        // Running prefix product (left → right)
        int pref = 1;

        // Running suffix product (right → left)
        int suff = 1;

        // Maximum seen in prefix scan
        int prefMax = Integer.MIN_VALUE;

        // Maximum seen in suffix scan
        int suffMax = Integer.MIN_VALUE;


        /*
         * -------- PREFIX PASS (LEFT → RIGHT) --------
         *
         * At each step:
         * pref *= nums[i]
         *
         * This builds cumulative product:
         * nums[0]
         * nums[0] * nums[1]
         * nums[0] * nums[1] * nums[2]
         * ...
         *
         * If product becomes zero:
         * We reset to 1 (new segment starts).
         */
        for (int i = 0; i < n; i++) {

            // If previous product was zero,
            // start fresh for new subarray
            if (pref == 0)
                pref = 1;

            // Build running product
            pref *= nums[i];

            // Track maximum seen so far in prefix direction
            prefMax = Math.max(prefMax, pref);
        }


        /*
         * -------- SUFFIX PASS (RIGHT → LEFT) --------
         *
         * Same idea but from the opposite side.
         *
         * Why needed?
         *
         * Example:
         * [-1, 2, 3]
         *
         * Prefix:
         * -1
         * -2
         * -6
         *
         * Max prefix = -1
         *
         * But correct answer is 6 (2 * 3).
         *
         * Suffix scan fixes this:
         * 3
         * 6
         * -6
         *
         * So scanning both sides ensures we
         * automatically ignore the bad side
         * when negatives are odd.
         */
        for (int i = n - 1; i >= 0; i--) {

            // Reset after zero
            if (suff == 0)
                suff = 1;

            // Build running suffix product
            suff *= nums[i];

            // Track maximum seen so far in suffix direction
            suffMax = Math.max(suffMax, suff);
        }

        /*
         * Final answer is the best seen
         * in either direction.
         */
        return Math.max(prefMax, suffMax);
    }
}