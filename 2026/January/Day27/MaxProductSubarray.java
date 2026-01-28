class Solution {

    public int maxProduct(int[] nums) {
        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // Reset prefix/suffix if product becomes 0
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre = pre * nums[i];           // prefix product
            suff = suff * nums[n - i - 1]; // suffix product

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }
}

/*
=============================
INTUITION
=============================

The maximum product subarray problem is tricky because:
- Negative numbers can flip the sign of the product
- Zeros break subarrays

Key observations:
1. A large product can appear after multiplying an EVEN number of negatives.
2. If we only go left → right, we may miss a better product that starts later.
3. Therefore, we scan the array from:
   - left to right (prefix product)
   - right to left (suffix product)

Whenever the product becomes 0, we reset it to 1 because:
- Any subarray containing 0 has product 0
- A new subarray must start after 0


=============================
ALGORITHM
=============================

1. Initialize:
   - pre = 1 (prefix product)
   - suff = 1 (suffix product)
   - ans = -infinity

2. Traverse the array once (i = 0 to n-1):
   - Multiply pre with nums[i]
   - Multiply suff with nums[n-i-1]
   - Update ans with max(pre, suff)

3. If pre or suff becomes 0:
   - Reset it to 1

4. Return ans

Time Complexity: O(n)
Space Complexity: O(1)


=============================
DRY RUN
=============================

Example:
nums = [2, 3, -2, 4]

Initial:
pre = 1, suff = 1, ans = -∞

i = 0:
pre = 1 * 2 = 2
suff = 1 * 4 = 4
ans = max(-∞, max(2, 4)) = 4

i = 1:
pre = 2 * 3 = 6
suff = 4 * -2 = -8
ans = max(4, max(6, -8)) = 6

i = 2:
pre = 6 * -2 = -12
suff = -8 * 3 = -24
ans = max(6, max(-12, -24)) = 6

i = 3:
pre = -12 * 4 = -48
suff = -24 * 2 = -48
ans = max(6, max(-48, -48)) = 6

Final Answer = 6
(subarray: [2, 3])


=============================
EDGE CASES
=============================

1. Single element
   nums = [-2]
   Output = -2

2. Contains zero
   nums = [2, 0, -1]
   Output = 2

3. All negatives (even count)
   nums = [-2, -3, -4]
   Output = 12

4. All negatives (odd count)
   nums = [-2, -3, -4, -5]
   Output = 60

5. Zeros in between
   nums = [-2, 0, -1]
   Output = 0

=============================
WHY THIS WORKS
=============================

By scanning from both ends:
- We capture subarrays that start after a negative or zero
- We avoid explicitly tracking max/min products
- Elegant O(1) space solution
=============================
*/
