class Solution {
    public int numOfWays(int n) {
        int mod = (int)1e9+7;
        long a =6;
        long b = 6;
        for(int i=2;i<=n;i++){
            long newA = (3*a + 2*b)%mod;
            long newB = (2*a + 2*b)%mod;
            a = newA;
            b = newB;

        }
        return (int)((a+b)%mod);
    }
}

/*
/*
LeetCode 1411
Pattern: Dynamic Programming (State-Based DP)
Time: O(n)
Space: O(1)
Mod: 1e9 + 7

Problem Idea:
- Paint an n x 3 grid using 3 colors
- No two adjacent cells (horizontal or vertical) can have the same color

Key Observation:
For each row, there are only TWO valid color patterns:
1) Type A (abc): all 3 cells have different colors → 6 ways
2) Type B (aba): first and third same, middle different → 6 ways

DP State Meaning:
a = number of ways to paint up to current row with pattern type A
b = number of ways to paint up to current row with pattern type B

Transition Logic:
newA = 3*a + 2*b
newB = 2*a + 2*b

Reasoning:
- Based on how many valid color choices exist for next row
- Derived by counting compatible transitions between pattern types

Final Answer:
Total ways = a + b (mod)

Key Insight:
Reduce a 2D coloring problem into constant DP states by pattern classification.
*/

