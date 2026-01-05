import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length()) return false;

        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

        }
        int windsize = s1.length();
        Map<Character,Integer> mp2 = new HashMap<>();
        int left =0;
        for(int right =0;right<windsize;right++){
            char ch = s2.charAt(right);
            mp2.put(ch,mp2.getOrDefault(ch,0)+1);
            
        }
        if(mp.equals(mp2)) return true;
        for(int right = windsize;right<s2.length();right++){
            char rightch = s2.charAt(right);
            mp2.put(rightch,mp2.getOrDefault(rightch,0)+1);
            char removeChar = s2.charAt(left);
            mp2.put(removeChar, mp2.get(removeChar) - 1);
            if(mp2.get(removeChar)==0){
                mp2.remove(removeChar);
            }
            left++;
            if(mp.equals(mp2)) return true;
        }
        
        return false;
    }
}
/*
LeetCode 567
Pattern: Fixed-Size Sliding Window + Frequency Matching
Time: O(n)
Space: O(1) (since alphabet size is fixed)

Problem Idea:
Check if any permutation of s1 exists as a substring in s2.

Key Observation:
- Any permutation of s1 must have the SAME character frequencies
- Window size is fixed = length of s1

Approach:
1) Build frequency map of s1
2) Build frequency map of first window in s2
3) Slide window one character at a time:
   - Add incoming character
   - Remove outgoing character
4) Compare frequency maps at each step

Why This Works:
- All permutations share identical frequency counts
- Sliding window ensures O(1) updates per step

Important Detail:
Remove characters from window map when count becomes 0
→ keeps map comparison accurate

Key Insight:
Permutation checking = frequency equality over fixed-size windows.
*/
