
/**
 * This question is dumb as fuck dont even get me started
 */
public class PaintFence {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.numWays(2, 3));
    }
    
}

class Solution3 {
    public int numWays(int n, int k) {
       if(n == 0) {
           return 0;
       }
        if(n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        
        int prev = k;
        int next = k * (k - 1);
        int total = prev + next;
        for (int i = 3; i <= n; i++) {
            prev = next * 1;
            next = total * (k -1);
            total = prev + next;
        }
        
        return total;
    }
}
