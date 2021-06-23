import java.util.HashSet;
import java.util.Set;

/**
 * Question = https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Longest substring is can be solved through a sliding window approach.
 * Maintain a set of unique characters
 *  iterate over the the substring(increasing right side of the window),
 *  if a duplicate char exists, slide the left side of the window until window has unique chars.
 *  update longest substring with each match.
 * 
 *  O(N) time | O(N) space
 */
public class LongestSubString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("au"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        Set<Character> uniqueChars = new HashSet<Character>();
        int longestSubString = 1;
        // left and right are pointers to the edge of sliding window.
        int left =0;
        
        for(int right = 0;right<=s.length()-1;right++) {
            char c = s.charAt(right);
            // in case char exists in set, slide window till
            // it does not contain it anymore
            while(uniqueChars.contains(c)){
                uniqueChars.remove(s.charAt(left));
                left++;
            }
            longestSubString = Math.max(right-left+1,longestSubString);
            uniqueChars.add(c);
        }
        
        return longestSubString;   
    }
}