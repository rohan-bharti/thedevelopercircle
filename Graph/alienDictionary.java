/**
 * Alien Dictionary. We do a topological sort to iterate over the words and create an adjacency list of characters to their successor characters.
 * Once we have the adjList, we use BFS and indegrees to check the increasing order is valid in the alien language ie no loops exist.
 *
 * Average - O(C) time where C is the total length of the characters in words array | O(1) space since fixed character set of 26
 */
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        int[] indegrees = new int[26];

        for(String word: words) {
            for(char c: word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String word = words[i];
            String nextWord = words[i+1];
            int len = Math.min(word.length(), nextWord.length());

            if(word.length() > nextWord.length() && word.startsWith(nextWord))
                return "";

            for(int j=0; j<len; j++) {
                if(word.charAt(j) != nextWord.charAt(j)) {
                    adjList.get(word.charAt(j)).add(nextWord.charAt(j));
                    indegrees[nextWord.charAt(j) - 'a']++;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c: adjList.keySet()) {
            if(indegrees[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while(!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for(Character ch: adjList.get(c)) {
                indegrees[ch - 'a']--;
                if(indegrees[ch - 'a'] == 0) {
                    queue.offer(ch);
                }
            }
        }

        return sb.toString().length() == adjList.size() ? sb.toString() : "";
    }
}

/**
 * Alien Dictionary with DFS, we create an adjacency list. Since DFS returns the leaf node first (in this case the largest character) so we store the
 * reverse mapping in the adjList to get the right order. Once we establish the relation between the nodes in the adjList, we use DFS to check if
 * there exists a cycle between the nodes meaning that the string isn't in the correct sorted format.
 *
 * Average - O(C) time where C is the total length of the characters in words array | O(1) space since fixed character set of 26
 */
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();

        for(String word: words) {
            for(char c: word.toCharArray()) {
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String word = words[i];
            String nextWord = words[i+1];
            int len = Math.min(word.length(), nextWord.length());

            if(word.length() > nextWord.length() && word.startsWith(nextWord))
                return "";

            for(int j=0; j<len; j++) {
                if(word.charAt(j) != nextWord.charAt(j)) {
                    // intentionally storing it in reverse mapping so that dfs does not give the reversed string
                    adjList.get(nextWord.charAt(j)).add(word.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
        StringBuilder result = new StringBuilder();
        for(char c: adjList.keySet()) {
            boolean doCyclesExist = dfs(c, adjList, visited, result);
            if(doCyclesExist) return "";
        }

        return result.toString().length() == adjList.size() ? result.toString() : "";
    }

    private boolean dfs(char c, Map<Character, List<Character>> map, Map<Character, Boolean> visited, StringBuilder sb) {
        if(visited.containsKey(c))
            return visited.get(c);

        visited.put(c, true);
        for(Character next: map.get(c)) {
            boolean doCyclesExist = dfs(next, map, visited, sb);
            if(doCyclesExist) return true;
        }

        visited.put(c, false);
        sb.append(c);
        return false;
    }
}