/*
PROBLEM INTUITION:
==================
We need to set entire row and column to 0 if any element in that position is 0.
The trick is to do this IN-PLACE without using extra space.

Solution: Use the first row and first column as markers to indicate which rows and columns should be zeroed.

DRY RUN EXAMPLE:
================
Input:
1 1 1
1 0 1
1 1 1

Step 1 - Mark zeros in first row/col:
When we find 0 at [1][1], we set matrix[1][0]=0 and matrix[0][1]=0
1 0 1
0 0 1
1 1 1

Step 2 - Set zeros based on marks (from index 1):
For each cell, if its row or column marker is 0, set it to 0
1 0 1
0 0 0
1 0 1

Step 3 - Handle first row and column using col0 flag:
If col0=0, set entire first column to 0
If matrix[0][0]=0, set entire first row to 0

ALGORITHM (Simple Steps):
=========================
1. Create a flag 'col0' to remember if first column should be zeroed
2. First Loop: Traverse all cells
   - If cell is 0, mark its row's first element as 0
   - If cell is 0 and NOT in column 0, mark its column's first element as 0
   - If cell is 0 and in column 0, set col0 flag to 0
3. Second Loop: Start from [1][1] (skip first row and column)
   - If current cell is NOT 0, but its row or column marker is 0, set it to 0
4. Third Step: Handle first row
   - If matrix[0][0] is 0, set all elements in first row to 0
5. Fourth Step: Handle first column
   - If col0 is 0, set all elements in first column to 0
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        // Flag to track if first column needs to be zeroed
        int col0 = 1;
        int n = matrix.length, m = matrix[0].length;
        
        // STEP 1: First pass - Mark all rows and columns that should be zeroed
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If current element is 0, mark its row and column
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; // Mark the first element of current row
                    if(j != 0){
                        matrix[0][j] = 0; // Mark the first element of current column
                    }else{
                        col0 = 0; // If 0 is in first column, remember to zero entire column
                    }
                }
            }
        }
        
        // STEP 2: Second pass - Set zeros based on markers (skip first row and column)
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                // If the element is not already 0
                if(matrix[i][j] != 0){
                    // Check if its row marker or column marker is 0
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0; // Set to 0
                    }
                }
            }
        }
        
        // STEP 3: Handle first row
        if(matrix[0][0] == 0){
            // If first cell is 0, set entire first row to 0
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        
        // STEP 4: Handle first column
        if(col0 == 0){
            // If col0 flag is 0, set entire first column to 0
            for(int j = 0; j < n; j++){
                matrix[j][0] = 0;
            }
        }
    }
}