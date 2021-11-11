/**
 * Spiral Matrix. We set the boundary conditions and iterate over the matrix in a spiral manner.
 *
 * Time - O(m.n) | Space - O(1) the output array is not included in the space complexity
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowNums = matrix.length;
        int colNums = matrix[0].length;

        int top = 0;
        int bottom = rowNums - 1;
        int left = 0;
        int right = colNums - 1;

        int totalNums = rowNums*colNums;

        while(result.size() < totalNums) {
            for(int i=left; i<=right && result.size() < totalNums; i++)
                result.add(matrix[top][i]);
            top++;
            for(int i=top; i<=bottom && result.size() < totalNums; i++)
                result.add(matrix[i][right]);
            right--;
            for(int i=right; i>=left && result.size() < totalNums; i--)
                result.add(matrix[bottom][i]);
            bottom--;
            for(int i=bottom; i>=top && result.size() < totalNums; i--)
                result.add(matrix[i][left]);
            left++;
        }

        return result;
    }
}