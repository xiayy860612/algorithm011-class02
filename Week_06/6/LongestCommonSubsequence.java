import java.util.Arrays;

class Solution {

    /**
     * 时间复杂度:O(m*n)
     * 空间复杂度: O(m+1 * n+1)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int cols = text1.length();
        int rows = text2.length();
        int[][] result = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[rows][cols];
    }

    public static void main(String[] args) {
        var result = new Solution().longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
    }
}