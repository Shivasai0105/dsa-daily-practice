
/*
Problem: Valid Palindrome (LeetCode 125)

Problem Explanation:
Given a string, determine if it is a palindrome considering
only alphanumeric characters and ignoring cases.

Key Requirements:
- Ignore non-alphanumeric characters
- Case-insensitive comparison
- Check palindrome property

Approach:
1. Convert the string to lowercase.
2. Filter only letters and digits using Character.isLetterOrDigit().
3. Store valid characters in a StringBuilder.
4. Use two pointers:
   - One from start
   - One from end
5. Compare characters while moving inward.

Why this works:
- Preprocessing simplifies the palindrome check.
- Two-pointer technique ensures linear comparison.

Time Complexity:
- O(n) → one pass to filter + one pass to compare

Space Complexity:
- O(n) → additional StringBuilder storage
*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(ch);
            }
        }
        int i =0,n = str.length(),j = n-1;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}