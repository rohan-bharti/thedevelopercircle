/**
 * Product of Array Except Self
 */
class productofArrayExceptSelf {
    /**
    Let's say the input is [1,2,3]
    We take two arrays - left and right.
    Left stores the multiplication of all the numbers to the left of the i index. Hence, left array eventually holds [1,1,2]
    Right stores the multiplication of all the numbers to the right of the i index. Hence, right array eventually holds [6,3,1]
    For obtaining the final result, we multiply the left[i]*right[i] to get the product of all the numbers except that ith number

    O(N) time and O(N) space
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int[] leftMultiplication = new int[nums.length];
        int[] rightMultiplication = new int[nums.length];
        
        leftMultiplication[0] = 1;
        for(int i=1; i<nums.length; i++) {
            leftMultiplication[i] = leftMultiplication[i-1]*nums[i-1];
        }
        
        rightMultiplication[nums.length - 1] = 1;
        for(int i=nums.length - 2; i>=0; i--) {
            rightMultiplication[i] = rightMultiplication[i+1]*nums[i+1];
        }
        
        for(int i=0; i<nums.length; i++) {
            result[i] = leftMultiplication[i]*rightMultiplication[i];
        }
        
        return result;
    }

    /**
    Same approach as discussed above but it is done in place.

    O(N) time and O(1) space
     */
    public int[] productExceptSelfConstantSpace(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i=1; i<nums.length; i++) {
            result[i] = result[i-1]*nums[i-1];
        }
        
        int right=1;
        for(int i=nums.length - 1; i>=0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }
}