import java.util.*;

/**
 * A sliding window problem to find the longest substring with at most 2 diff characters,
 * we use a hashmap to store characters of the string and their respective indicies. Once the hashmap
 * goes over the length of 2, we remove the character with the least occurance to get the longest substring
 * and point the start of the sliding window to the next of the lowest index.
 * 
 * Average - O(N) time N is the length of the string
 * | O(1) space
 */
class SolutionLOLSW2DC {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int maxLength = 0;
        
        for(int end=0; end<s.length(); end++) {
            char currentChar = s.charAt(end);
            map.put(currentChar, end);
            
            if(map.size() == 3) {
                //point the start variable to the min index of the characters in the window
                start = Collections.min(map.values());
                map.remove(s.charAt(start));
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start+1);
        }
        
        return maxLength;
    }
}