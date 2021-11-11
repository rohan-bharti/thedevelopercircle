/**
 * Set Matrix Zeroes. We create two sets to store the index of rows and columns to be set to zero. In the first pass,
 * we check which elements are zero and set the corresponding row and col index in the respective sets to zero. In the second pass,
 * we check if the current row or col index belongs to either of the sets, if yes, then the element is set to zero.
 *
 * Time - O(m.n) | Space - O(m+n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/**
 * Set Matrix Zeroes. The two sets created in the prev solution are converted to (in place) first row and col of the matrix. In the first pass,
 * we follow a similar logic and update the first row and col as per the matrix elements. However, the first index (0,0) will be common to both the
 * in place sets, so we take an extra boolean variable to check if the entire first row needs to be set to 0. The first element (0,0) by default is considered
 * as a check for the first column. In the second pass, we run a check for all the elements (except 0 indices) by referring to the inplace sets.
 * In the third pass, we check if the first element (0,0) is zero (set the entire first col to 0) and if the rowZero var is true, set the entire
 * first row to zero.
 *
 * Time - O(m.n) | Space - O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        boolean rowZero = false;

        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if(matrix[i][j] == 0) {
                    // in place col set
                    matrix[0][j] = 0;

                    if(i==0)
                        // check for first row since 0,0 is a part of the in place col set
                        rowZero = true;
                    else
                        // in place row set [1,rowNum]
                        matrix[i][0] = 0;
                }
            }
        }

        // check for all the elements except the first row/col which is handled later
        for(int i=1; i<rowNum; i++) {
            for(int j=1; j<colNum; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0)
            for(int i=0; i<rowNum; i++)
                matrix[i][0] = 0;

        if(rowZero)
            for(int j=0; j<colNum; j++)
                matrix[0][j] = 0;
    }
}

/**
 * Set Matrix Zeroes. This approach is using DFS to see which cells are zero and mark the corresponding rows and cols to zero. We need a visited matrix
 * to keep a check for the visited elements to avoid duplicacy.
 *
 * Time - O(m.n) | Space - O(m.n)
 */
class Solution {
    int rowNum;
    int colNum;

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;

        rowNum = matrix.length;
        colNum = matrix[0].length;

        boolean[][] visited = new boolean[rowNum][colNum];

        for(int i=0; i<rowNum; i++) {
            for(int j=0; j<colNum; j++) {
                if(matrix[i][j] == 0 && !visited[i][j])
                    dfs(matrix, i, j, visited);
            }
        }
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if(x<0 || y<0 || x>=rowNum || y>=colNum || visited[x][y])
            return;

        for(int i=0; i<rowNum; i++) {
            if(grid[i][y] != 0) {
                visited[i][y] = true;
                grid[i][y] = 0;
            }
        }

        for(int j=0; j<colNum; j++) {
            if(grid[x][j] != 0) {
                visited[x][j] = true;
                grid[x][j] = 0;
            }
        }
    }
}