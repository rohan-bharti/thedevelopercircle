/**
We count the number of '1' bits up till n for each n in the array. For each integer n, if we take an AND with n-1, we set the least
significant bit to 0. We continue doing this till all the 1 bits are set to 0.

Average - O(n*logn) time because each integer contains 32 bits. | O(n) space
 */
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i=0; i<=n; i++) {
            int count=0;
            int num=i;
            while(num != 0) {
                num = num&(num-1);
                count++;
            }
            result[i] = count;
        }

        return result;
    }
}

/**
DP and Least Significant bit.
8 = [1000] => 1 '1'
7 = [0101] => 2 '1'
4 = [0100] => 1 '1'

The idea is to get the num of 1's in num/2 and add modulo with 2.

Average - O(n) time | O(n) space
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            // x / 2 is x >> 1 and x % 2 is x & 1
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }
}

/**
DP and Least Significant bit. We check the number of 1's in the number with 1 '1' less by removing the least significant bit. We add the 1 to
the num with 1 '1' less to get the result.

Average - O(n) time | O(n) space
 */
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            dp[i] = dp[i & (i-1)] + 1;
        }

        return dp;
    }
}