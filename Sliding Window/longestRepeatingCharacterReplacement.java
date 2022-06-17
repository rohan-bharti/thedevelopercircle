import java.util.*;

/**
 * A sliding window problem to find the longest substring with repeating characters, provided
 * we can flip the characters in the substring k times to make it identical to the most repeating
 * character and this is where the sliding window problem comes into the picture.
 *
 * Average - O(N) time N is the length of the string
 * | O(M) space where M is the number of unique characters in the String.
 */
class SolutionLRCR {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> windowCharCount = new HashMap<>();

        int maxLength = 0;
        int start = 0;
        int maxRepeatedwindowCharCount = 0;

        for(int end=0; end<s.length(); end++) {
            char currentChar = s.charAt(end);
            if(windowCharCount.containsKey(currentChar))
                windowCharCount.put(currentChar, windowCharCount.get(currentChar) + 1);
            else
                windowCharCount.put(currentChar, 1);

            maxRepeatedwindowCharCount = Math.max(maxRepeatedwindowCharCount, windowCharCount.get(currentChar));

            //sliding window - repeated characters = unique characters in the window
            //unique characters if less than k, can be flipped
            //else we increment the start and move the window
            if(end-start+1 - maxRepeatedwindowCharCount > k) {
                windowCharCount.put(s.charAt(start), windowCharCount.get(s.charAt(start)) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }
}