/**
 * Valid Anagram. Keep a track of the frequencies of chars in both the strings and check if it is the same for both the strings.
 *
 * Time Complexity: O(N) Time | O(1) Space since the size of the charCount arrays remain constant
 */
class Solution {
    public boolean isAnagram(String main, String pattern) {
        if(main.length() != pattern.length())
            return false;

        int[] mainCharsCount = new int[26];
        int[] patternCharsCount = new int[26];

        for(char c: main.toCharArray()) {
            mainCharsCount[c - 'a']++;
        }

        for(char c: pattern.toCharArray()) {
            patternCharsCount[c - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(mainCharsCount[i] != patternCharsCount[i])
                return false;
        }

        return true;
    }
}

// More elegant solution
class Solution {
    public boolean isAnagram(String main, String pattern) {
        if(main.length() != pattern.length())
            return false;

        int[] count = new int[26];

        for(int i=0; i<main.length(); i++) {
            count[main.charAt(i) - 'a']++;
            count[pattern.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++) {
            if(count[i] != 0)
                return false;
        }

        return true;
    }
}