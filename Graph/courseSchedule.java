/**
 * Course Schedule with DFS and memoization. We use a hashmap to a pre req course and its next courses. The idea it to traverse a path from each of the courses
 * and see if there exists a cycle for the graph nodes. If a cycle exists it means we cannot complete the courses.
 *
 * Average - O(V+E) time | O(V+E) space
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // holds a map of a preq course and all its next courses
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // populate the prereq course and its next courses
        for(int[] preReq : prerequisites) {
            List<Integer> nextCourses = adjList.getOrDefault(preReq[1], new ArrayList<>());
            nextCourses.add(preReq[0]);
            adjList.put(preReq[1], nextCourses);
        }

        // check if there exists a cycle which means two courses are prereq for each other (making it impossible to cover the courses)
        for(int i=0; i<numCourses; i++) {
            if(isCyclicGraph(i, adjList, new boolean[numCourses], new boolean[numCourses]))
                return false;
        }

        return true;
    }

    private boolean isCyclicGraph(int course, Map<Integer, List<Integer>> adjList, boolean[] path, boolean[] visited) {
        // tracks if there exists a cycle for the course path
        if(path[course])
            return true;

        // to avoid visiting the same node multiple times. If this is true, it means we have checked the possible paths
        // for this node and no cycles exist
        if(visited[course])
            return false;

        // if the course is not a pre req
        if(!adjList.containsKey(course))
            return false;

        // backtracking start
        path[course] = true;
        boolean result = false;
        for(Integer nextCourse : adjList.get(course)) {
            result = this.isCyclicGraph(nextCourse, adjList, path, visited);
            if(result)
                break;
        }
        path[course] = false;
        // backtracking end

        visited[course] = true;
        return result;
    }
}

/**
 * Course Schedule with BFS (Performs Better). We use topological sort to check if there exists a cycle between the graph nodes.
 * We use an array - indegrees to keep a track of incoming edges for the vertices. If at a certain point no node has a 0 indegree,
 * that means there is no place to start (or in technical terms there exists a cycle among the nodes).
 *
 * Average - O(V+E) time | O(V+E) space
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // holds a map of a preq course and all its next courses
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // an array of indegrees for the courses
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        // create a mapping between the courses (vertices) and next courses (edges) respectively; keep a count of the indegrees
        for(int[] preReq: prerequisites) {
            List<Integer> nextCourses = adjList.getOrDefault(preReq[1], new ArrayList<>());
            nextCourses.add(preReq[0]);
            indegree[preReq[0]]++;
            adjList.put(preReq[1], nextCourses);
        }

        // add the nodes with 0 indegrees
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int currCourse = queue.poll();

            count++;
            if(!adjList.containsKey(currCourse))
                continue;

            for(int nextCourse: adjList.get(currCourse)) {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0)
                    queue.offer(nextCourse);
            }
        }

        // count keeps a track of the non cyclic vertices
        return count == numCourses;
    }
}

/**
 * Improved DFS.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] preReq: prerequisites) {
            adjList.putIfAbsent(preReq[0], new ArrayList<>());
            adjList.get(preReq[0]).add(preReq[1]);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        for(int num=0; num < numCourses; num++) {
            if(!dfs(num, adjList, visited))
               return false;
        }
        
        return true;
    }
    
    private boolean dfs(int currCourse, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(currCourse))
            return false;
        
        if(!adjList.containsKey(currCourse))
            return true;
        
        visited.add(currCourse);
        for(int preReq: adjList.get(currCourse)) {
            if(!dfs(preReq, adjList, visited))
                return false;
        }
        
        visited.remove(currCourse);
        adjList.remove(currCourse);
        return true;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        
        for(int[] preReq: prerequisites) {
            adjList.putIfAbsent(preReq[0], new ArrayList<>());
            adjList.get(preReq[0]).add(preReq[1]);
            indegrees[preReq[1]]++;
        }
        
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0)
                queue.offer(i);
        }
        
        int validCourses = 0;
        while(!queue.isEmpty()) {
            int currCourse = queue.remove();
            
            validCourses++;
            if(!adjList.containsKey(currCourse))
                continue;
            
            for(int preReq: adjList.get(currCourse)) {
                indegrees[preReq]--;
                
                if(indegrees[preReq] == 0)
                    queue.offer(preReq);
            }
        }
        
        return validCourses == numCourses;
    }
}