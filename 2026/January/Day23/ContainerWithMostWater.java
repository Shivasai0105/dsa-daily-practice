class Solution {
    public int maxArea(int[] height) {

        // Number of vertical lines
        int n = height.length;

        // Two pointers: left at start, right at end
        int l = 0, r = n - 1;

        // Stores the maximum area found so far
        int maxArea = 0;

        // Continue until the two pointers meet
        while (l < r) {

            // Width is the distance between pointers
            // Height is the minimum of the two lines
            int area = (r - l) * Math.min(height[l], height[r]);

            // Update maximum area if current area is larger
            maxArea = Math.max(area, maxArea);

            // Move the pointer with the smaller height
            // because moving the taller one cannot increase area
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        // Return the maximum water container area
        return maxArea;
    }
}

/*
========================== DRY RUN ==========================

Input:
height = [1,8,6,2,5,4,8,3,7]

Initial:
l = 0 → height[l] = 1
r = 8 → height[r] = 7
maxArea = 0

------------------------------------------------------------

Iteration 1:
width = 8 - 0 = 8
minHeight = min(1, 7) = 1
area = 8 * 1 = 8
maxArea = 8

height[l] < height[r] → move left
l = 1

------------------------------------------------------------

Iteration 2:
l = 1 → height = 8
r = 8 → height = 7
width = 7
minHeight = 7
area = 49
maxArea = 49

height[l] > height[r] → move right
r = 7

------------------------------------------------------------

Iteration 3:
l = 1 → 8
r = 7 → 3
width = 6
minHeight = 3
area = 18
maxArea = 49

height[l] > height[r] → r--
r = 6

------------------------------------------------------------

Iteration 4:
l = 1 → 8
r = 6 → 8
width = 5
minHeight = 8
area = 40
maxArea = 49

heights equal → move left
l = 2

------------------------------------------------------------

Further iterations produce smaller areas.
Pointers eventually meet.

------------------------------------------------------------

Final Answer:
maxArea = 49

========================== KEY IDEAS =========================

1. Area depends on width × smaller height
2. Width always decreases as pointers move
3. To possibly increase area, move the pointer
   with the smaller height
4. This guarantees O(n) time complexity

============================================================
*/
