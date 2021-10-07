/**
 * Sum of Two Integers. We use XOR to calculate the bit wise sum of the two integers. For calculating carries we use AND and a left shift
 * of 1 bit to correctly add the carry to the result. We do the above operations till the carry is not zero.
 * 
 * Average - O(1) time because each integer contains 32 bits. | O(N) space
 */
class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;
        
        if(carry == 0)
            return xor;
        else
            return getSum(xor, carry << 1);
    }
}