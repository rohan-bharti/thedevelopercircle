import java.util.*;

/**
 * For solving this problem, we need equal number of open and close parentheses in the string and we cannot have
 * a close parentheses before an open one. We append the string with a parentheses if the conditions are met
 * and backtrack our way to generate possible combinations of valid parentheses.
 * 
 * Average - O(1/(N+1)2NCn) time | O(N) space
 */
class SolutionGP {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, 0, 0);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int max, int open, int close) {
        if(current.length() == max*2) {
            result.add(current);
            return;
        }
        
        if(open<max)
            backtrack(result, current+"(", max, open+1, close);
        if(close<open)
            backtrack(result, current+")", max, open, close+1);
    }
}
