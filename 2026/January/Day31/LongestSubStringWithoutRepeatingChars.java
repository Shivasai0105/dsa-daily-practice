import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        int left =0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(mp.containsKey(ch)){
                left = Math.max(left, mp.get(ch) + 1);

            }
            
            mp.put(ch,i);
            maxLen = Math.max(i-left+1,maxLen);
        }
        return maxLen;
    }
}