/**
 * Number of 1 bits. We iterate over all the 32 bits of the integer and do an AND operation with each of the bits and '1' bit. We move the 1 bit
 * in the mask to the left with each iteration and keep a count of the total number of 1s. The AND operation with a 1 must give an integer > 0.
 * 
 * Average - O(1) time because each integer contains 32 bits. | O(1) space
 */
public class Solution {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        
        // n is a 32 bit integer
        for(int i=0; i<32; i++) {
            if((n & mask) != 0)
                count++;
            
            mask <<= 1;
        }
        
        return count;
    }
}

/**
 * Number of 1 bits. We do an AND operation with n and n-1 to flip the least '1' significant bit. By doing this we can continue the process
 * to eventually flip all the 1 bits to 0 and keep a count of those as well.
 * 
 * Average - O(1) time because each integer contains 32 bits. | O(1) space
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        // n is a 32 bit integer
        while(n!=0) {
            n = n&(n-1);
            count++;
        }
        
        return count;
    }
}