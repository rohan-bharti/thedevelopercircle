import java.util.*;

/**
 * Word Break. We create a DP boolean array and iterate over the characters of the string.
 * We create every possible substring up till the iterating character and check if it belongs
 * to the incoming wordDictionary.
 *
 * Average - O(N^2) time | O(N) space
 */
public class wordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                String subString = s.substring(j,i);
                if(dp[j] && wordDict.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}