import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
class GenerateParenthesis {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        help(0, 0, n, "", result);
        return result;
    }

    private void help(int left, int right, int max, String str, List<String> result) {
        if (left == max && right == max) {
            result.add(str);
            return;
        }

        if (left < max) {
            help(left + 1, right, max, str + "(", result);
        }

        if (right < left) {
            help(left, right + 1, max, str + ")", result);
        }
    }
}