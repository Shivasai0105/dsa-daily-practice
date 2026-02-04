/*
========================================================
SINGLE ELEMENT IN SORTED ARRAY — COMPLETE NOTES
========================================================

ARRAY PROPERTY
--------------------------------------------------------
Every element appears EXACTLY twice except ONE element.

Example:
[1,1,2,2,3,3,4,5,5,6,6]
                ↑ single element

Goal → find the single element in O(log n)

--------------------------------------------------------
CORE INTUITION (MOST IMPORTANT)
--------------------------------------------------------
In a normal paired array:

Index : 0 1 2 3 4 5 6 7
Array : 1 1 2 2 3 3 4 4

Pairs follow a PATTERN:

First element of pair → EVEN index
Second element → ODD index

Pattern:
even index == next element

But after the SINGLE element appears,
the pattern BREAKS.

Example:
[1,1,2,2,3,3,4,5,5,6,6]
                ↑ single

Before single:
even index → pair starts correctly

After single:
odd index → pair starts

So binary search finds where pattern breaks.

--------------------------------------------------------
KEY DECISION RULE
--------------------------------------------------------
We check if mid is correctly paired.

If mid is EVEN:
    it should match nums[mid+1]

If mid is ODD:
    it should match nums[mid-1]

If pairing is correct → single is on RIGHT
If pairing is broken → single is on LEFT

--------------------------------------------------------
ALGORITHM
--------------------------------------------------------
1) Handle edge cases:
   - only 1 element
   - first element is single
   - last element is single

2) Binary search on pattern break.

--------------------------------------------------------
DRY RUN
--------------------------------------------------------
nums = [1,1,2,2,3,3,4,5,5,6,6]

low=1 high=9

mid=5 → nums[5]=3 (odd index)
nums[5]==nums[4] → pair correct → go right

low=6 high=9
mid=7 → nums[7]=5 (odd index)
nums[7]!=nums[6] → pattern broken → go left

mid=6 → nums[6]=4 → answer

--------------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------------
O(log n)
========================================================
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Edge cases
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int low=1, high=n-2;

        while(low<=high){
            int mid = low+(high-low)/2;

            // Found the single element
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
                return nums[mid];

            // Check pairing pattern
            if((mid%2==0 && nums[mid]==nums[mid+1]) ||
               (mid%2==1 && nums[mid]==nums[mid-1]))
            {
                // pattern correct → single on RIGHT
                low = mid + 1;
            }
            else{
                // pattern broken → single on LEFT
                high = mid - 1;
            }
        }

        return -1;
    }
}
