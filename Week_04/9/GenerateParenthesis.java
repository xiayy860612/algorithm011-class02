import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();
        dfs("", n, 0, 0, result);
        return result;
    }

    private void dfs(String cur, int max, int left, int right, List<String> result) {
        if (left == max && right == max) {
            result.add(cur);
            return;
        }

        if (left < max) {
            dfs(cur + "(", max, left + 1, right, result);
        }

        if (left > right) {
            dfs(cur + ")", max, left, right + 1, result);
        }
    }
}