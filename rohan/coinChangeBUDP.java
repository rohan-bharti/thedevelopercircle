import java.util.*;

/**
 * Coin Change Solution. Each index is a representation of an amount value in the dp array. We check using the coins array,
 * if by using one or multiple, can we make their sum equal to the i value.
 * 
 * Average - O(N*M) time | O(M) space where N is the amount value, M is the number of coins
 */
class SolutionCCBUDP {
    public int coinChange(int[] coins, int amount) {
        int[] numOfCoins = new int[amount+1];

        for(int i=1; i<numOfCoins.length; i++) {
            numOfCoins[i] = amount+1;
        }

        //base case
        numOfCoins[0] = 0;

        for(int i=1; i<numOfCoins.length; i++) {
            for(int coin: coins) {
                if(coin <= i) {
                    // The "coin" index we are subtracting is the coin that would amount to the i value if added, hence +1 to the numOfCoins
                    numOfCoins[i] = Math.min(numOfCoins[i], numOfCoins[i-coin] + 1);
                }
            }
        }

        return numOfCoins[amount] > amount ? -1 : numOfCoins[amount];
    }
}