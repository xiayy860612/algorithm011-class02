import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 */
class Combinations {
    /**
     * 回溯法
     */
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new LinkedList<>());
        return result;
    }

    private void backtrack(int num, int n, int k, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            result.add(new LinkedList<>(cur));
            return;
        }

        for (int i = num; i <= n; ++i) {
            cur.add(i);
            backtrack(i + 1, n, k, cur);
            cur.removeLast();
        }
    }

}