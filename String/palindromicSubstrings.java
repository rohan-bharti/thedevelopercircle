/**
 * Palindromic Substrings. We check for the odd and even length of palindromes available and increment the count accordingly.
 *
 * Time Complexity: O(N^2) Time | O(1) Space
 */
class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int count = 0;

        for(int i=0; i<s.length(); i++) {
            // odd characters palindromes
            int left = i, right = i;
            while(left>=0 && right<s.length()) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                }

                count++;
                left--;
                right++;
            }

            // even character palindromes
            left = i;
            right = i+1;
            while(left>=0 && right<s.length()) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                }

                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}