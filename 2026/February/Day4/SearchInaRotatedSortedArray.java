/*
========================================================
SEARCH IN ROTATED SORTED ARRAY — COMPLETE NOTES
========================================================

ARRAY TYPE:
A sorted array rotated at some pivot.

Example:
Sorted  : [1 2 3 4 5 6 7]
Rotated : [4 5 6 7 0 1 2]

Goal → find index of target in O(log n)

--------------------------------------------------------
CORE INTUITION
--------------------------------------------------------
In every iteration, ONE HALF of the array is ALWAYS sorted.

Example:
[4 5 6 7 | 0 1 2]

At any time we ask TWO QUESTIONS:
1) Which half is sorted?
2) Is target inside that sorted half?

Then we discard half of the array.

This keeps binary search alive even after rotation.

--------------------------------------------------------
HOW TO DETECT SORTED HALF
--------------------------------------------------------

If nums[low] <= nums[mid]
    → LEFT half is sorted

Else
    → RIGHT half is sorted

--------------------------------------------------------
WHAT TO DO AFTER FINDING SORTED HALF
--------------------------------------------------------

CASE 1: LEFT HALF SORTED
Range = nums[low] → nums[mid]

If target lies in this range:
    nums[low] <= target <= nums[mid]
    → search LEFT (high = mid - 1)

Else:
    → search RIGHT (low = mid + 1)


CASE 2: RIGHT HALF SORTED
Range = nums[mid] → nums[high]

If target lies in this range:
    nums[mid] < target <= nums[high]
    → search RIGHT (low = mid + 1)

Else:
    → search LEFT (high = mid - 1)

--------------------------------------------------------
DRY RUN
--------------------------------------------------------
nums = [4,5,6,7,0,1,2], target = 0

Iteration 1:
low=0 high=6 mid=3 → nums[mid]=7
Left half sorted (4..7)
Target not in [4..7] → move right
low = 4

Iteration 2:
low=4 high=6 mid=5 → nums[mid]=1
Left half sorted (0..1)
Target in [0..1] → move left
high = 4

Iteration 3:
low=4 high=4 mid=4 → nums[mid]=0
Target found → return 4

--------------------------------------------------------
TIME COMPLEXITY
--------------------------------------------------------
Binary search → O(log n)
Space → O(1)
========================================================
*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int high = n-1;
        int low = 0;

        while(low<=high){
            int mid = low+(high-low)/2;

            // Target found
            if(nums[mid]==target){
                return mid;
            }

            // Check if LEFT half is sorted
            if(nums[low]<=nums[mid]){

                // Target lies in LEFT half
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid-1;
                }else{
                    low = mid+1;
                }

            }else{ // RIGHT half is sorted

                // Target lies in RIGHT half
                if(nums[mid]<target && nums[high]>=target){
                    low = mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }
}
