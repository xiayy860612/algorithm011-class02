import sun.jvm.hotspot.gc.shared.Generation;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和:
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * @see <a href="https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/">LeetCode题解</a>
 */
class TwoSum {

    /**
     * 哈希查找目标值
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] solution2(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int rest = target - nums[i];
            if (hash.containsKey(rest)) {
                return new int[] {i, hash.get(rest)};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}