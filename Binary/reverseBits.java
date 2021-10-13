/**
 * Reverse Bits. We iterate over the bits in the number n, take them out, put it in the result and left shift it to move it to the
 * beginning of the result.
 * 
 * Average - O(32) time | O(1) space
 */
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for(int i=0; i<32; i++) {
            int end = n & 1; // taking the AND to get the last digit
            n = n >> 1; // right shifting n to get the next digit
            result = result << 1; // left shifting result for storing new digit
            result |= end; // adding the value to the in the position created above
        }
        
        return result;
    }
}