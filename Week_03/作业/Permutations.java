import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
class Permutations {
    /**
     * 回朔法
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, new LinkedList<>(), used);
        return result;
    }

    private void dfs(int[] nums, LinkedList<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            result.add(new LinkedList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }

            cur.add(nums[i]);
            used[i] = true;

            dfs(nums, cur, used);

            used[i] = false;
            cur.removeLast();
        }
    }
}