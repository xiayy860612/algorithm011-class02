import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
class Permutations2 {
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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

            // !used[i-1]: 说明i-1和i目前是同父级的不同子节点的尝试, 发现一样就剪掉
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
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