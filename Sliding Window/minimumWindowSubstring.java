import java.util.*;

/**
 * Since we have to find a subset and this is a String problem, seems like a
 * sliding window problem.
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