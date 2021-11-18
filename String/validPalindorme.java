/**
 * Valid Palindrome. In the first pass, we get rid of the spaces and non letter or digit characters. After, we iterate the two pointers
 * accordingly and if there's a difference, we return false.
 *
 * Time Complexity: O(N) Time | O(N) Space
 */
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;

            start++;
            end--;
        }

        return true;
    }
}