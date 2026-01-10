class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // dp[i][j] = minimum ASCII delete sum to make
        // s1[0..i-1] and s2[0..j-1] equal
        int[][] dp = new int[n + 1][m + 1];

        // Base case: s2 is empty, delete all characters from s1
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Base case: s1 is empty, delete all characters from s2
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    // No deletion needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Delete either c1 or c2
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + c1,
                        dp[i][j - 1] + c2
                    );
                }
            }
        }

        return dp[n][m];
    }
}
