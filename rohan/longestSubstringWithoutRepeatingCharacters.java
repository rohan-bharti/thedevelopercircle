import java.util.*;

/**
 * We take a sliding window with two pointers - 'left and right'. While traversing the string, we store the 
 * character in a hashmap and add the next index (right+1) to it as the value. When we encounter the same
 * character again, we increment the left pointer to point to the next index of the prev location of the
 * charcater and update the map with its new found index. During each itertaion, we compute the maxLength.
 * 
 * Average - O(N) time | O(M) space (N is the number of characters in the String, M is the number of unique characters)
 * Worst - O(N) time | O(M) space (N is the number of characters in the String, M is the number of unique characters)
 */
class SolutionLOLS {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                //incrementing the window if we encounter the same character
                left = Math.max(map.get(s.charAt(right)), left);
            }
            
            maxLength = Math.max(maxLength, right-left+1);
            
            //We are pointing to the rightmost end of the window
            map.put(s.charAt(right), right+1);
        }
        
        return maxLength;
    }
}