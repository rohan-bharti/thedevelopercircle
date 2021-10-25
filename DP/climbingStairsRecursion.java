/**
 * In Climbing Stairs, for each step, we can only take 1 or 2
 * steps, which gives us the recurrence relation and the base
 * case is we can step on a single step in 1 way and 0 stairs
 * in also one way.
 */
class SolutionCSR {
    public int climbStairs(int n) {
        return recurse(n);
    }

    private int recurse(int n) {
        if(n==0 || n==1) {
            return 1;
        }

        return recurse(n-1) + recurse(n-2);
    }
}