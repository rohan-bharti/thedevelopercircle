import java.util.*;

/**
 * Backtracking problem. We iterate over the cells of the board and see if we wanna place the Queen at that particular cell. We check for
 * the diagonal, the anti diagonal and the vertical column for each of the placed positions.
 * 
 * Time Complexity: O(N!) 1 Queen N, 2 Queen N-2, 3 Queen N-4| O(N2) because of the board
 */
class SolutionNQ {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[][] board = new int[n][n];

        placeQueens(board, 0, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        
        return result;
    }
    
    private void placeQueens(int[][] board, int row, List<List<String>> result, Set<Integer> diag1, Set<Integer> diag2, Set<Integer> vertical) {
        if(row == board.length) {
            formatBoard(board, result);
            return;
        }
        
        for(int col=0; col<board[row].length; col++) {
            if(!diag1.contains(row+col) && !diag2.contains(row-col) && !vertical.contains(col)) {
                board[row][col] = 1;
                diag1.add(row+col);
                diag2.add(row-col);
                vertical.add(col);
                placeQueens(board, row+1, result, diag1, diag2, vertical);
                board[row][col] = 0;
                diag1.remove(row+col);
                diag2.remove(row-col);
                vertical.remove(col);
            }
        }
    }
    
    private void formatBoard(int[][] board, List<List<String>> result) {
        List<String> rowList = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == 1)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            rowList.add(sb.toString());
        }
        result.add(rowList);
    }
}