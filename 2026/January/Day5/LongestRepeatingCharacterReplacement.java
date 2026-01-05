import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxLen =0,maxFreq=0;
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        for(int r =0;r<n;r++){
            char ch = s.charAt(r);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            maxFreq= Math.max(maxFreq,mp.get(ch));
            while((r-l+1)-maxFreq>k){
                char c = s.charAt(l);
                mp.put(c,mp.get(c)-1);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}

/*
LC 424 – Longest Repeating Character Replacement

Pattern: Variable-Size Sliding Window

What the problem is really asking

You can replace at most k characters so that a substring becomes all the same character.
Return the maximum possible length of such a substring.

Core Idea

In any window:

changes needed = window size − frequency of most common character


The window is valid if:

(window size − maxFreq) ≤ k

Why sliding window?

We want the longest contiguous substring

Window expands greedily

Shrinks only when invalid

Important Trick (Very important)

maxFreq is never decreased when shrinking the window.

Why this still works:

Even if maxFreq is stale, it only makes the condition looser.

Window size correctness is preserved.

This avoids recomputation → O(n).

Common Pitfall

❌ Trying to keep frequency map perfectly accurate
❌ Recalculating maxFreq every time

Final Insight

Track dominance, not exact distribution.
*/