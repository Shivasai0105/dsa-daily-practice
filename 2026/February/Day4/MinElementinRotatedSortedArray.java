public class MinElementinRotatedSortedArray {
    

/*
========================================================
FIND MINIMUM IN ROTATED SORTED ARRAY — COMPLETE NOTES
========================================================

Problem:
We are given a sorted array rotated at some pivot.
Example:
Sorted  : [1 2 3 4 5 6 7]
Rotated : [4 5 6 7 0 1 2]

Goal → Find the minimum element in O(log n)

--------------------------------------------------------
CORE IDEA
--------------------------------------------------------
A rotated sorted array actually contains TWO sorted parts.

        [4 5 6 7 | 0 1 2]
         part 1    part 2

There is exactly ONE place where sorted order breaks:
        7 > 0   ← rotation point

The minimum is the START of the second sorted part.

So the problem becomes:
→ Find where the SECOND SORTED PART begins.

--------------------------------------------------------
THE MAGIC TRICK (MOST IMPORTANT)
--------------------------------------------------------
We need a way to know whether an element belongs to:
1) First sorted part
2) Second sorted part

We use the LAST ELEMENT as reference.

Example:
[4 5 6 7 0 1 2]
            ↑ last element = 2

Now we can classify ANY element:

If nums[i] > last  → element is in FIRST PART
If nums[i] <= last → element is in SECOND PART

This makes binary search possible.

--------------------------------------------------------
BINARY SEARCH DECISION
--------------------------------------------------------
Pick mid and ask:
Is mid in first part or second part?

Compare:
        nums[mid] vs nums[high]

CASE 1:
nums[mid] < nums[high]
→ mid is in SECOND sorted part
→ minimum could be mid OR to the LEFT
→ move left
        high = mid

CASE 2:
nums[mid] > nums[high]
→ mid is in FIRST sorted part
→ minimum must be to the RIGHT
→ move right
        low = mid + 1

--------------------------------------------------------
WHEN DO WE STOP?
--------------------------------------------------------
Binary search stops when:
        low == high

We have found the START of second sorted part.
That index holds the minimum.

Return nums[low]

--------------------------------------------------------
ONE LINE INTUITION
--------------------------------------------------------
Binary search keeps asking:
"Is mid before rotation or after rotation?"

When search space collapses → we land on rotation point.
========================================================
*/

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                // mid is in SECOND sorted part → move left
                high = mid;
            } else {
                // mid is in FIRST sorted part → move right
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
