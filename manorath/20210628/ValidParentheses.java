import java.util.Stack;

public class ValidParentheses {
    
}
/**
 * Question : https://leetcode.com/problems/valid-parentheses/submissions/
 * Use a stack to keep track of last seen parentheses
 * 
 * Time O(n) | Space O(n)
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for(int i = 0;i<=arr.length -1;i++) {
            switch(arr[i]) {
                case '{': {
                    stack.add('}');
                    break;
                }
                case '(': {
                    stack.add(')');
                    break;
                }
                case '[': {
                    stack.add(']');
                    break;
                }
                default : {
                    try {
                    if(stack.peek() == arr[i]){
                        stack.pop();
                    } else{
                        return false;
                    }
                    break;
                    } catch (Exception ex){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}