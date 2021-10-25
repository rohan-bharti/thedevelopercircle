
import java.util.*;

/**
 * Word Break. We backtract to generate all the possible combinations of the given string,
 * also keep a track of the visited starting indices, and check if the generated combination
 * belongs to the word dictionary.
 *
 * Average - O(N^3) time size of the recursion goes to O(N^2)| O(N) space
 */
class wordBreakDFS {
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean backtrack(String s, List<String> dict, int start, Boolean[] memo) {
        if(start == s.length())
            return true;

        if(memo[start] != null)
            return memo[start];

        for(int end=start+1; end<=s.length(); end++) {
            String substring = s.substring(start, end);
            if(dict.contains(substring) && backtrack(s, dict, end, memo))
                return memo[start] = true;
        }

        return memo[start] = false;
    }
}
