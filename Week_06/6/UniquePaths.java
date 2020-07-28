import java.util.Arrays;

class Solution {

    /**
     * 时间复杂度: O(m*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int col = 1; col < n; ++col) {
            grid[0][col] = 1;
        }
        for (int row = 1; row < m; ++row) {
            grid[row][0] = 1;
        }

        for (int row = 1; row < m; ++row) {
            for (int col = 1; col < n; ++col) {
                grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}