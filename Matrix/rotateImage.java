/**
 * Rotate Image. The idea is to go over the elements of the matrix and first transpose them along the diagonal of the matrix.
 * Once we do that we interchange them along the middle of the matrix, the result comes out to be a 90 degrees clockwise rotated
 * matrix.
 *
 * Time - O(N) N being the total elements of the matrix | Space - O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;

        int size = matrix.length;

        // transposing the matrix along the diagonal
        for(int i=0; i<size; i++) {
            for(int j=i; j<size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reflection
        for(int i=0; i<size; i++) {
            for(int j=0; j<(size/2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size-1-j];
                matrix[i][size-1-j] = temp;
            }
        }
    }
}

/**
The idea is firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
*/