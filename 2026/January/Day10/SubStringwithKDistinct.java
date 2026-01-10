
import java.util.*;
class Solution {

    private int atMostK(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while (mp.size() > k) {
                char c = s.charAt(left);
                mp.put(c, mp.get(c) - 1);
                if (mp.get(c) == 0) {
                    mp.remove(c);
                }
                left++;
            }

            // number of valid substrings ending at `right`
            res += right - left + 1;
        }

        return res;
    }
        public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMostK(s, k) - atMostK(s, k - 1);
    }



}