/**
 * Word Search. We iterate over the cells in the matrix and check if we find a match for the first character. If we do, then we run a dfs to see
 * if we can find the remianing characters of the word.
 *
 * Average - O(M.N) time | O(M.N) space in the worst case for the recursion stack if the word we are searching for is the entire matrix
 */
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    int rowsNum, colsNum;

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;

        rowsNum = board.length;
        colsNum = board[0].length;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {
        if(index == word.length())
            return true;

        if(x<0 || y<0 || x>=rowsNum || y>=colsNum || board[x][y] != word.charAt(index))
            return false;

        boolean result = false;
        board[x][y] = ' ';

        for(int[] dir: dirs) {
            result = dfs(board, x + dir[0], y + dir[1], word, index+1);
            if(result)
                return true;
        }

        board[x][y] = word.charAt(index);
        return result;
    }
}