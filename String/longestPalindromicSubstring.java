/**
 * Longest Palindromic Substring. This is the brute force method. We do a O(n^2) to generate all the substrings and for each of the substrings
 * generated, we check if it is a palindrome or not. If yes, we compare the length of the prev palindrome length, whichever is greater, we
 * update the result to that palindrome.
 *
 * Time Complexity: O(N^3) Time | O(1) Space
 */
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int length = 0;

        for(int start=0; start<s.length(); start++) {
            for(int end=start; end<s.length(); end++) {
                String substring = s.substring(start, end+1);
                if(isPalindrome(substring)) {
                    int currLength = substring.length();
                    if(currLength > length) {
                        result = s.substring(start, end+1);
                        length = currLength;
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            if(str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}

/**
 * Longest Palindromic Substring. We iterate over the indices of the string, and expand from them (check for both even and odd lengths),
 * check if the substring is a palindrome or not.
 *
 * Time Complexity: O(N^2) Time | O(1) Space
 */
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int length = 0;

        for(int i=0; i<s.length(); i++) {
            // Odd length
            int left = i, right = i;
            while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > length) {
                    result = s.substring(left, right+1);
                    length = right-left+1;
                }

                left--;
                right++;
            }

            // Even length
            left = i;
            right = i+1;
            while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > length) {
                    result = s.substring(left, right+1);
                    length = right-left+1;
                }

                left--;
                right++;
            }
        }

        return result;
    }
}