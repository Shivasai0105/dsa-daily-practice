/*
========================================================
PROBLEM: Sort Colors (Dutch National Flag Algorithm)
========================================================

Given an array nums[] containing only:
    0 → Red
    1 → White
    2 → Blue

Task:
- Sort the array in-place
- One pass only (O(n))
- No extra space

--------------------------------------------------------
KEY IDEA (Dutch National Flag)
--------------------------------------------------------

We divide the array into FOUR logical parts using 3 pointers:

    low, mid, high

At any moment:

    [0 ........ low-1]      → all 0s
    [low ...... mid-1]      → all 1s
    [mid ...... high]       → unknown (to be processed)
    [high+1 ... end]        → all 2s

IMPORTANT:
- The algorithm ALWAYS makes decisions using nums[mid]
- low and high are only boundaries, not decision pointers

--------------------------------------------------------
POINTER INITIALIZATION
--------------------------------------------------------

    low = 0
    mid = 0
    high = nums.length - 1

--------------------------------------------------------
RULES (VERY IMPORTANT)
--------------------------------------------------------

1) If nums[mid] == 0
   - 0 belongs to the left side
   - Swap nums[low] and nums[mid]
   - Move both low and mid forward

2) If nums[mid] == 1
   - 1 is already in correct position
   - Just move mid forward

3) If nums[mid] == 2
   - 2 belongs to the right side
   - Swap nums[mid] and nums[high]
   - Move high backward
   - DO NOT move mid (new value is unprocessed)

--------------------------------------------------------
LOOP CONDITION
--------------------------------------------------------

    while (mid <= high)

Why?
- Because everything after high is already sorted (2s)

--------------------------------------------------------
CORRECT SWAP FUNCTION
--------------------------------------------------------
*/

class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }
}

/*
========================================================
DRY RUN (STEP-BY-STEP EXAMPLE)
========================================================

Input:
    nums = [2, 0, 2, 1, 1, 0]

Initial:
    low = 0, mid = 0, high = 5

--------------------------------------------------------
Step 1:
nums[mid] = nums[0] = 2
→ swap(mid, high)

Array: [0, 0, 2, 1, 1, 2]
high-- → high = 4
mid stays = 0

--------------------------------------------------------
Step 2:
nums[mid] = nums[0] = 0
→ swap(low, mid) (same index)

Array: [0, 0, 2, 1, 1, 2]
low++ → 1
mid++ → 1

--------------------------------------------------------
Step 3:
nums[mid] = nums[1] = 0
→ swap(low, mid)

Array: [0, 0, 2, 1, 1, 2]
low++ → 2
mid++ → 2

--------------------------------------------------------
Step 4:
nums[mid] = nums[2] = 2
→ swap(mid, high)

Array: [0, 0, 1, 1, 2, 2]
high-- → 3
mid stays = 2

--------------------------------------------------------
Step 5:
nums[mid] = nums[2] = 1
→ mid++

mid = 3

--------------------------------------------------------
Step 6:
nums[mid] = nums[3] = 1
→ mid++

mid = 4

--------------------------------------------------------
STOP:
mid (4) > high (3)

Final Output:
    [0, 0, 1, 1, 2, 2]

========================================================
COMMON MISTAKES (WHAT YOU DID WRONG EARLIER)
========================================================

❌ Checking nums[low] instead of nums[mid]
❌ Incrementing pointers blindly
❌ Wrong loop condition
❌ Broken swap logic
❌ Ignoring the invariant

========================================================
TIME & SPACE
========================================================

Time Complexity:  O(n)
Space Complexity: O(1)

========================================================
END OF NOTES
========================================================
*/
