import java.util.*;
/**
 * Since we have to find a subset and this is a String problem, seems like a sliding window problem.
 * 
 * Average - O(N) time | O(1) space
 */
class SolutionFAAS {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(s.length() == 0 || p.length() == 0 || s == null || p == null)
            return result;
        
        if(s.length() < p.length())
            return result;
        
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();
        
        for (char c: p.toCharArray()) {
            if (pCount.containsKey(c)) {
                pCount.put(c, pCount.get(c) + 1);
            } 
            else {
                pCount.put(c, 1);    
            }
        }
        
        for (int end=0; end < s.length(); end++) {
            char tmp = s.charAt(end);
            if (sCount.containsKey(tmp)) {
                sCount.put(tmp, sCount.get(tmp) + 1);
            }
            else {
                sCount.put(tmp, 1);
            }
            
            if(end >= p.length()) {
                char leftmostChar = s.charAt(end - p.length());
                if(sCount.get(leftmostChar) == 1)
                    sCount.remove(leftmostChar);
                else
                    sCount.put(leftmostChar, sCount.get(leftmostChar) - 1);
            }
            
            if(sCount.equals(pCount)) {
                result.add(end - p.length() + 1);
            }
        }
        
        return result;
    }
}