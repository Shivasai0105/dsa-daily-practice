import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        int left =0;
        int maxLen = 0;
        for(int right =0;right<n;right++){
            char ch = s.charAt(right);
            if(mp.containsKey(ch)){
                left =  Math.max(left, mp.get(ch) + 1);
                
            }
            mp.put(ch,right);
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
/*
LeetCode 3
Pattern: Variable-Size Sliding Window
Time: O(n)
Space: O(min(n, charset))

Problem Idea:
Find the length of the longest substring with all unique characters.

Window Strategy:
- Use two pointers: left and right
- Expand right pointer to include new characters
- Shrink left pointer only when a duplicate is found

State Maintained:
- Map<Character, Integer> stores the LAST index of each character
- left pointer always represents the start of a valid window

Critical Logic:
When a duplicate character appears:
left = max(left, lastIndexOfChar + 1)

Why max() is needed:
- Prevents left from moving backward
- Ensures window remains valid

Key Insight:
Each character is processed at most twice → linear time.

Mistake to Avoid:
Never reset the window completely; always adjust left intelligently.
*/
