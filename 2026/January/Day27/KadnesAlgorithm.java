class Solution {

    public int maxSubArray(int[] nums) {

        int max = nums[0];      // stores maximum subarray sum
        int curr = nums[0];     // current subarray sum

        int strt = 0;           // temporary start index
        int beststrt = 0;       // best subarray start
        int bestend = 0;        // best subarray end

        for (int i = 1; i < nums.length; i++) {

            int temp = curr + nums[i];

            // Decide whether to extend subarray or start new one
            if (nums[i] > temp) {
                curr = nums[i];
                strt = i;
            } else {
                curr = temp;
            }

            // Update best answer
            if (curr > max) {
                max = curr;
                beststrt = strt;
                bestend = i;
            }
        }

        // Print the maximum subarray
        for (int i = beststrt; i <= bestend; i++) {
            System.out.println(nums[i]);
        }

        return max;
    }
}

/*
=============================
INTUITION
=============================

This is Kadane’s Algorithm with index tracking.

At each position, we ask:
- Is it better to EXTEND the previous subarray?
- Or START a new subarray from the current element?

If nums[i] alone is better than curr + nums[i],
we discard the previous subarray and start fresh.

To print the actual subarray:
- We track where a new subarray starts (strt)
- Whenever we find a better max sum, we store its start and end indices


=============================
ALGORITHM
=============================

1. Initialize:
   - curr = nums[0]
   - max = nums[0]
   - strt = beststrt = bestend = 0

2. Traverse from index 1 to n-1:
   - temp = curr + nums[i]
   - If nums[i] > temp:
       curr = nums[i]
       strt = i
     Else:
       curr = temp
   - If curr > max:
       max = curr
       beststrt = strt
       bestend = i

3. Print elements from beststrt to bestend

4. Return max

Time Complexity: O(n)
Space Complexity: O(1)


=============================
DRY RUN
=============================

Example:
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Initial:
curr = -2
max = -2
strt = 0
beststrt = 0, bestend = 0

i = 1 (1):
temp = -2 + 1 = -1
1 > -1 → start new subarray
curr = 1, strt = 1
curr > max → update
max = 1, beststrt = 1, bestend = 1

i = 2 (-3):
temp = 1 + (-3) = -2
-3 > -2 ❌
curr = -2
(no update)

i = 3 (4):
temp = -2 + 4 = 2
4 > 2 → start new
curr = 4, strt = 3
update max → max = 4, beststrt = 3, bestend = 3

i = 4 (-1):
curr = 3 (extend)

i = 5 (2):
curr = 5 → update max
beststrt = 3, bestend = 5

i = 6 (1):
curr = 6 → update max
beststrt = 3, bestend = 6

Remaining elements don’t improve max.

Subarray printed:
[4, -1, 2, 1]

Returned max = 6


=============================
EDGE CASES
=============================

1. Single element
   nums = [5]
   Output = 5
   Subarray = [5]

2. All negative numbers
   nums = [-3, -2, -5]
   Output = -2
   Subarray = [-2]
   ✔ Works because initialization starts from nums[0]

3. All positive numbers
   nums = [1, 2, 3]
   Output = 6
   Subarray = [1, 2, 3]

4. Zeroes included
   nums = [-2, 0, -1]
   Output = 0
   Subarray = [0]

5. Multiple max subarrays
   nums = [1, -1, 1, -1, 1]
   Output = 1
   Prints the first max subarray found


=============================
IMPORTANT NOTES (VERIFIED)
=============================

✔ This version correctly tracks indices  
✔ Handles all-negative arrays (common pitfall)  
✔ Printing subarray is safe because indices are updated only on improvement  
✔ Equivalent to standard Kadane’s Algorithm, but richer (gives subarray)

=============================
*/
