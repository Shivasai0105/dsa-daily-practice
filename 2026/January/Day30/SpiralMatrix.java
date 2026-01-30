import java.util.*;

/*
==========================================================
SPIRAL MATRIX – SIMPLE, READABLE EXPLANATION
==========================================================

Goal:
Given a matrix, return all elements in spiral order.

Example:
1  2  3
4  5  6
7  8  9

Spiral order:
1 2 3 6 9 8 7 4 5

----------------------------------------------------------
CORE IDEA (THIS IS THE KEY):
----------------------------------------------------------
We do NOT think in terms of directions.
We think in terms of BOUNDARIES.

At any moment, the matrix that is not yet visited
is surrounded by 4 boundaries:

top    -> first unvisited row
bottom -> last unvisited row
left   -> first unvisited column
right  -> last unvisited column

We always traverse in this fixed order:
1) top row        (left → right)
2) right column   (top → bottom)
3) bottom row     (right → left)
4) left column    (bottom → top)

After traversing one side, we MOVE that boundary inward.

We stop when boundaries cross.
==========================================================
*/

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        // Edge case: empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize boundaries
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        /*
        We continue while there is still a valid rectangle
        that has not been visited.
        */
        while (top <= bottom && left <= right) {

            // 1️⃣ Traverse TOP row (left → right)
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;   // top row is now fully used

            // 2️⃣ Traverse RIGHT column (top → bottom)
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // right column is now fully used

            /*
            Before traversing bottom row,
            we must check that top <= bottom
            (important for single-row matrices)
            */
            if (top <= bottom) {
                // 3️⃣ Traverse BOTTOM row (right → left)
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // bottom row is now fully used
            }

            /*
            Before traversing left column,
            we must check that left <= right
            (important for single-column matrices)
            */
            if (left <= right) {
                // 4️⃣ Traverse LEFT column (bottom → top)
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // left column is now fully used
            }
        }

        return result;
    }
}

/*
==========================================================
HOW TO RE-DERIVE THIS IN AN INTERVIEW
==========================================================

1) Say: "I will use 4 boundaries: top, bottom, left, right"
2) Say: "I will always move in this order:
          top row → right column → bottom row → left column"
3) After each traversal, shrink the boundary
4) Stop when boundaries cross

If you remember ONLY this, you can code it again.
==========================================================
*/

/*
==========================================================
TIME & SPACE COMPLEXITY
==========================================================

Time:  O(m × n)
Space: O(1) extra space (output list excluded)

This is optimal because every element must be visited.
==========================================================
*/
