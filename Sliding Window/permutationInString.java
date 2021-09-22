import java.util.*;

/**
 * Fixed size sliding window problem. We take the sliding window as the size of the smaller string
 * and iterate the window through the longer string and check if a permutation exists for the smaller
 * string in the longer string.
 * 
 * Time Complexity: O(N) Time | O(1) Space
 */
class SolutionPIS {
    public boolean checkInclusion(String s1, String s2) {
        int[] baseString = new int[26];
        int[] window = new int[26];
        
        for(char c: s1.toCharArray())
            baseString[c - 'a']++;
        int start=0;
        
        for(int end=0; end<s2.length(); end++) {
            window[s2.charAt(end) - 'a']++;
            
            if(end - start + 1 > s1.length()) {
                window[s2.charAt(start) - 'a']--;
                start++;
            }
            
            if(match(baseString, window))
                return true; 
        }
        
        return false;
    }
    
    private boolean match(int[] arr1, int[] arr2) {
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
