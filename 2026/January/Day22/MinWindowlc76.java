import java.util.*;
class Solution {
    public String minWindow(String s, String t) {

        // Lengths of input strings
        int m = s.length(), n = t.length();

        // Map to store required frequency of characters in t
        Map<Character, Integer> mp = new HashMap<>();

        // count tracks how many required characters
        // (including correct frequency) are currently satisfied
        int count = 0;

        // Stores minimum window length found so far
        int minLen = Integer.MAX_VALUE;

        // Sliding window pointers
        int left = 0, right = 0;

        // Starting index of minimum window
        int sidx = -1;

        // Build frequency map for string t
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Expand window using right pointer
        while (right < m) {

            char c = s.charAt(right);

            // If character is required and still needed,
            // one required character is satisfied
            if (mp.containsKey(c) && mp.get(c) > 0) {
                count++;
            }

            // Decrease frequency since character is included in window
            mp.put(c, mp.getOrDefault(c, 0) - 1);

            // When all required characters are satisfied
            while (count == n) {

                // Update minimum window if smaller window is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sidx = left;
                }

                // Character to be removed from the window
                char cl = s.charAt(left);

                // Restore frequency since we are shrinking window
                mp.put(cl, mp.get(cl) + 1);

                // If frequency becomes positive,
                // window is no longer valid
                if (mp.get(cl) > 0) {
                    count--;
                }

                // Shrink window from the left
                left++;
            }

            // Expand window
            right++;
        }

        // If no valid window found
        if (sidx == -1) {
            return "";
        }

        // Return the minimum window substring
        return s.substring(sidx, sidx + minLen);
    }
}

/*
========================== DRY RUN ==========================

Input:
s = "ADOBECODEBANC"
t = "ABC"

Initial:
mp = {A=1, B=1, C=1}
count = 0
left = 0, right = 0
minLen = INF

------------------------------------------------------------

right = 0 → 'A'
mp['A'] > 0 → count = 1
mp['A']-- → A=0

right = 1 → 'D'
not required → count unchanged
mp['D'] = -1

right = 2 → 'O'
not required

right = 3 → 'B'
mp['B'] > 0 → count = 2
mp['B']-- → B=0

right = 4 → 'E'
not required

right = 5 → 'C'
mp['C'] > 0 → count = 3
mp['C']-- → C=0

Now count == n (3), window = "ADOBEC"

------------------------------------------------------------
Start shrinking:

Window length = 6 → minLen = 6, sidx = 0

left = 0 → 'A'
mp['A']++ → A=1
mp['A'] > 0 → count = 2
Stop shrinking

------------------------------------------------------------
Continue expanding:

Eventually window becomes "BANC"

Window length = 4 → minLen = 4, sidx = 9

------------------------------------------------------------

Final Answer:
"BANC"

========================== KEY IDEAS =========================

1. Right pointer expands window to satisfy requirements
2. count == n means window is valid
3. Left pointer shrinks window to minimize length
4. Frequency map tells when window becomes invalid
5. Smallest valid window is tracked using minLen

============================================================
*/
