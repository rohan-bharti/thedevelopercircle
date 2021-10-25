/**
 * Decode Ways. We iterate over the string, get the next 1 and 2 character sets respectively,
 * , check if they form a valid sequence and use DFS to reach the end of the string. If we successfully
 * reach the end of the string, that means that we have validated all the subsequent decodings and hence we increment
 * the results variable by 1.
 *
 * Average - O(N) time - N since each caculation will be once | O(N) space for memo array
 */
class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return helper(s, 0, memo);
    }

    private int helper(String s, int index, int[] cache) {
        // traversed the entire string hence sucessful decoding done
        if(index >= s.length())
            return 1;

        // check if memoized result exists
        if(cache[index] > -1)
            return cache[index];

        // generate combinations to decode and check validity
        int result = 0;
        for(int i=1; i<=2; i++) {
            if(i + index <= s.length()) {
                String number = s.substring(index, index + i);
                if(isValid(number)) {
                    result += helper(s, index+i, cache);
                }
            }
        }

        cache[index] = result;
        return result;
    }

    private boolean isValid(String token) {
        if(token.length() == 0 || token.charAt(0) == '0')
            return false;

        int value = Integer.parseInt(token);
        return value >=1 && value <=26;
    }
}

/**
 * Decode Ways. Bottom Up Processing. We set the base cases for an empty string and a string with 1 char
 * value. We check for valid decodings upon string traversal and update the dp array accordingly.
 *
 * Average - O(N) time | O(N) space for dp array
 */
class Solution {
    public int numDecodings(String s) {
        // dp holds the number of ways you can decode the string up till ith index
        int[] dp = new int[s.length() + 1];

        dp[0] = 1; //1 way to decode an empty string which is no way
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2; i<=s.length(); i++) {
            // check for the previous 1 digit to be valid
            if(Integer.parseInt(s.substring(i-1, i)) >= 1)
                dp[i] = dp[i-1];

            // check for the previous two figits to be valid
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            if(twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i-2];
        }

        return dp[s.length()];
    }
}