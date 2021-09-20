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
        Map<Character, Integer> mainStringCount = new HashMap<>();
        Map<Character, Integer> permuteStringCount = new HashMap<>();
        int start=0;
        
        for(char c: s1.toCharArray()) {
            if(permuteStringCount.containsKey(c)) 
                permuteStringCount.put(c, permuteStringCount.get(c) + 1);
            else
                permuteStringCount.put(c, 1);
        }
        
        for(int end=0; end<s2.length(); end++) {
            char c = s2.charAt(end);
            if(mainStringCount.containsKey(c)) 
                mainStringCount.put(c, mainStringCount.get(c) + 1);
            else
                mainStringCount.put(c, 1);
            
            if(end-start+1 > s1.length()) {
                if(mainStringCount.get(s2.charAt(start)) == 1)
                    mainStringCount.remove(s2.charAt(start));
                else 
                    mainStringCount.put(s2.charAt(start), mainStringCount.get(s2.charAt(start)) - 1);
                start++;
            }
            
            if(permuteStringCount.equals(mainStringCount))
                return true;
        }
        
        return false;
    }
}
