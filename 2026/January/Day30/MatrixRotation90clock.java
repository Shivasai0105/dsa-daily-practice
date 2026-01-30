/*
PROBLEM INTUITION:
==================
Rotate a 90-degree clockwise rotation of a matrix in-place.
The key insight: A 90-degree clockwise rotation is equivalent to:
  1. Transpose the matrix (swap elements across diagonal)
  2. Reverse each row

DRY RUN EXAMPLE:
================
Input Matrix (3x3):
1 2 3
4 5 6
7 8 9

STEP 1 - Transpose (swap elements across main diagonal):
Swap matrix[i][j] with matrix[j][i]
1 4 7
2 5 8
3 6 9

STEP 2 - Reverse each row:
Row 0: 1 4 7 → 7 4 1
Row 1: 2 5 8 → 8 5 2
Row 2: 3 6 9 → 9 6 3

Final Output (90-degree clockwise rotation):
7 4 1
8 5 2
9 6 3

ALGORITHM (Simple Steps):
=========================
1. Get the number of rows and columns (n = number of rows)
2. TRANSPOSE: Swap elements across the main diagonal
   - For each element at position [i][j] where j > i
   - Exchange it with element at [j][i]
   - This creates a mirror image across the diagonal
3. REVERSE ROWS: Reverse each row from left to right
   - For each row, swap elements from start and end moving towards center
   - This completes the 90-degree clockwise rotation
*/

class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row; // n is size of square matrix
        
        // STEP 1: Transpose the matrix (swap across main diagonal)
        // This mirrors the matrix from top-left to bottom-right diagonal
        for(int i = 0; i < row; i++){
            // Start from i+1 to avoid swapping twice and diagonal elements
            for(int j = i + 1; j < col; j++){
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // STEP 2: Reverse each row
        // This completes the 90-degree clockwise rotation
        for(int i = 0; i < n; i++){
            int left = 0, right = n - 1;
            // Two pointer approach to reverse the row
            while(left < right){
                // Swap elements from left and right, moving towards center
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                right--;
                left++;
            }
        }
    }
}