/**
 * Valid Parentheses. We iterate over the parentheses in the string given, for each opening one, we push a closing one.
 * Upon encountering a closing one, we check if the stack has that closing one on the top or not while popping the stack.
 *
 * Time Complexity: O(N) Time | O(N) Space
 */
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0)
            return false;

        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }

        // The stack should be empty at the end, if not we didn't get a valid set of parentheses
        return stack.isEmpty();
    }
}