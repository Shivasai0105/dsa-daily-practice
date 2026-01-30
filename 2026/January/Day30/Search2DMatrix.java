/**
 * Search in a 2D Matrix — All 3 Approaches
 *
 * We cover THREE different matrix constraints:
 *
 * 1) Only rows are sorted
 * 2) Rows AND columns are sorted
 * 3) Fully sorted matrix (global order)
 *
 * Each approach is correct ONLY for its matching constraint.
 */

public class Search2DMatrix {

    /* =========================================================
       APPROACH 1: Row-wise Binary Search
       ---------------------------------------------------------
       CONDITION:
       - Each row is sorted
       - NO guarantee about ordering between rows
       
       IDEA:
       - For each row, run binary search
       
       TIME:  O(n log m)
       SPACE: O(1)
       ========================================================= */
    public static boolean searchRowWiseBinary(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        for (int[] row : matrix) {
            int low = 0, high = row.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (row[mid] == target)
                    return true;
                else if (row[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    /* =========================================================
       APPROACH 2: Staircase Search (Top-Right)
       ---------------------------------------------------------
       CONDITION:
       - Rows sorted left → right
       - Columns sorted top → bottom
       
       IDEA:
       - Start from top-right corner
       - Move left if value is too big
       - Move down if value is too small
       
       TIME:  O(n + m)
       SPACE: O(1)
       ========================================================= */
    public static boolean searchStaircase(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;        // eliminate column
            else
                i++;        // eliminate row
        }
        return false;
    }

    /* =========================================================
       APPROACH 3: Flattened Binary Search (OPTIMAL)
       ---------------------------------------------------------
       CONDITION:
       - Fully sorted matrix
       - Last element of a row < first element of next row
       
       IDEA:
       - Treat matrix as a sorted 1D array of size n*m
       - Use binary search
       
       Mapping:
       row = index / m
       col = index % m
       
       TIME:  O(log(n*m))
       SPACE: O(1)
       ========================================================= */
    public static boolean searchFlattenedBinary(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    /* =========================================================
       TEST CASES
       ========================================================= */
    public static void main(String[] args) {

        // Fully sorted matrix (LeetCode 74 type)
        int[][] fullySorted = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Row & column sorted (LeetCode 240 type)
        int[][] rowColSorted = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16}
        };

        int target1 = 16;
        int target2 = 13;

        System.out.println("Row-wise Binary Search:");
        System.out.println(searchRowWiseBinary(fullySorted, target1)); // true
        System.out.println(searchRowWiseBinary(fullySorted, target2)); // false

        System.out.println("\nStaircase Search:");
        System.out.println(searchStaircase(rowColSorted, target1));    // true
        System.out.println(searchStaircase(rowColSorted, target2));    // false

        System.out.println("\nFlattened Binary Search (Optimal):");
        System.out.println(searchFlattenedBinary(fullySorted, target1)); // true
        System.out.println(searchFlattenedBinary(fullySorted, target2)); // false
    }
}
