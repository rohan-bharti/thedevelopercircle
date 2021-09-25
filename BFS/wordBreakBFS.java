import java.util.*;

/**
 * Word Break. We have a boolean array of checking the visisted characters. We poll
 * the characters (end) one by one, and add that to a queue. We check all possible substrings
 * to that end character if they belong to the word Dictionary.
 * 
 * Average - O(N^3) time | O(N) space
 */
public class SolutionWBBFS {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int start = queue.remove();
            
            if(visited[start])
                continue;
            
            for(int end=start+1; end<=s.length(); end++) {
                if(wordDict.contains(s.substring(start, end))) {
                    queue.add(end);
                    if(end == s.length())
                        return true;
                }
            }
            
            visited[start] = true;
        }
        
        return false;
    }
}