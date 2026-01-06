/*
Problem: Robot Return to Origin (LeetCode 657)

Problem Explanation:
A robot starts at (0,0) and moves according to instructions:
- 'U' up
- 'D' down
- 'L' left
- 'R' right

Determine if the robot returns to the origin after all moves.

Approach:
1. Maintain x and y coordinates.
2. Traverse each character in the string:
   - Update x or y accordingly.
3. After processing all moves:
   - If x == 0 and y == 0 → return true.

Why this works:
- Movements cancel out if the robot returns to origin.
- Direct simulation is sufficient.

Time Complexity:
- O(n) → one traversal of the string

Space Complexity:
- O(1) → constant space for coordinates
*/
class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for(int i=0;i<moves.length();i++){
            char ch = moves.charAt(i);
             if (ch == 'U') {
                y++;
            } else if (ch == 'D') {
                y--;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'R') {
                x++;
            }
        }
        if(x==0 && y==0) return true;
        return false;
    }
}