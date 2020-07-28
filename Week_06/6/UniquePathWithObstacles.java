import java.util.Arrays;

class Solution {

    /**
     * 时间复杂度: O(m*n)
     * 空间复杂度: O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[obstacleGrid.length - 1].length;
        int[] result = new int[n];
        result[0] = 1;

        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                if (obstacleGrid[row][col] == 1) {
                    result[col] = 0;
                    continue;
                }
                // col == 0 ==> result[col] = result[col]
                if(col > 0) {
                    result[col] += result[col - 1];
                }
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {

    }
}