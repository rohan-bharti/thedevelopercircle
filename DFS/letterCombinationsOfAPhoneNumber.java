import java.util.*;

/**
 * DFS Problem. We iterate over the sample space (Numeric chars corresponding to a String), we pick each character in the String
 * one by one, map it to the other Strings based on the numeric chars and create combinations out of them.
 * 
 * Time Complexity: ~3^N Time (Since each letter in digits maps to an average of 3 characters, N being the recursion stack)
 * | O(N) N being the size of the recursion stack
 */
class SolutionLCOAPN {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        generateCombinations(result, digits, map, "", 0);

        return result;
    }
    
    private static void generateCombinations(List<String> result, String digits, Map<Character, String> map, String current, int pos) {
        if(pos == digits.length()) {
            result.add(current);
            return;
        }
        
        String currString = map.get(digits.charAt(pos));
        for(int i=0; i<currString.length(); i++) {
            generateCombinations(result, digits, map, current + currString.charAt(i), pos+1);
        }
    }
}
