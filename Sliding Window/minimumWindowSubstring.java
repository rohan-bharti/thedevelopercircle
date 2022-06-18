import java.util.*;

/**
 * Minimum Window Substring. We take two pointers - start and end. The pattern string(t) is put into a hashmap with chars and their
 * frequencies. We create a window map, and start moving the end pointer in the search string. If the current end char is a required char
 * and its frequency matches the frequency in pattern string, we inc the number of chars matched.
 *
 * Once the number of chars matched is equal to the pattern string hashmap size, we check if we can move the start pointer and reduce the length
 * of the substring that contains all the characters in t. While inc the start, we check if the char we are removing is a required character
 * or not, based on which we decrement the charsMatched counter. By doing this, we keep a track of the minimum length of the substring.
 *
 * Average - O(M + N) time | O(M + N) space M-length of s; N-length of t
 */
class minimumWindowSubstring {
    public String minWindow(String s, String t) {
        // Push the characters of string t into a map
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = tMap.getOrDefault(c, 0);
            tMap.put(c, count + 1);
        }

        // stores the unique characters in the window and respective frequencies
        Map<Character, Integer> window = new HashMap<>();

        int start = 0;
        int end = 0;
        // tracks the number of unique characters to be matched
        int charsMatched = 0;
        String result = "";
        int minWindowSize = Integer.MAX_VALUE;

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            // checking if the charcater in the window matches an entry in tMap
            boolean charMatch = tMap.containsKey(currentChar);
            if (charMatch) {
                // match the frequency of matched char in window and tmap
                boolean isCharRequired = tMap.get(currentChar).intValue() == window.get(currentChar).intValue();
                if (isCharRequired) {
                    charsMatched++;
                }
            }

            // once the chars and their frequencies match to tMap size
            while (charsMatched == tMap.size() && start <= end) {
                char startChar = s.charAt(start);

                int windowSize = end - start + 1;
                if (windowSize < minWindowSize) {
                    minWindowSize = windowSize;
                    result = s.substring(start, end + 1);
                }

                // moving the start pointer forward to compute the minimum size window
                window.put(startChar, window.get(startChar) - 1);
                boolean isStartCharRequired = tMap.containsKey(startChar);
                if (isStartCharRequired) {
                    // check if after removal of a frequency of reqd char messes up charsMatched
                    boolean charWasRequired = window.get(startChar).intValue() < tMap.get(startChar).intValue();
                    if (charWasRequired)
                        charsMatched--;
                }
                start++;
            }
            end++;
        }

        return result;
    }
}

// Elegant solution
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCharsCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        int uniqueCharsMatch = 0;        
        int left=0;
        int minWindowSize = Integer.MAX_VALUE;
        
        String result = "";

        for(char c: t.toCharArray()) {
            tCharsCount.put(c, tCharsCount.getOrDefault(c, 0) + 1);
        }
        
        for(int right=0; right<s.length(); right++) {
            Character currChar = s.charAt(right);
            //adding to the window
            window.put(currChar, window.getOrDefault(currChar, 0) + 1);
            
            if(
                tCharsCount.containsKey(currChar) &&
                tCharsCount.get(currChar).equals(window.get(currChar))
              )
                uniqueCharsMatch++;
            
            //checking when to slide the window
            while(uniqueCharsMatch == tCharsCount.size() && left <= right) {
                //computing the result
                if(right-left+1 < minWindowSize) {
                    minWindowSize = right-left+1;
                    result = s.substring(left, right+1);
                }
                
                //incrementing the window
                char startChar = s.charAt(left);
                window.put(startChar, window.get(startChar) - 1);
                
                if(
                    tCharsCount.containsKey(startChar) &&
                    window.get(startChar).intValue() < tCharsCount.get(startChar).intValue()
                )
                    uniqueCharsMatch--;
                left++;
            }
        }
        
        return result;
    }
}