import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 窗口数: N - k + 1
 *
 * - [双端队列解法视频](https://leetcode-cn.com/problems/sliding-window-maximum/solution/shi-pin-jie-xi-shuang-duan-dui-lie-hua-dong-chuang/)
 * - [LeetCode官方解法](https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/)
 */
class MaxSlidingWindow {
    /**
     * 不推荐
     * 暴力求解
     *
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(n-k+1)
     */
    public int[] solution1(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; ++j) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    /**
     * 推荐
     * 双向队列:
     * - 只保留当前窗口中的元素索引, 即每次移动, 要移除不是当前窗口中的元素索引
     * - 保证头元素为最大值, 即每次新元素添加进来时, 如果移除所有比它小的元素的索引
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n-k+1)
     */
    public int[] solution2(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            cleanDeque(nums, deque, k, i);
            deque.addLast(i);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; ++i) {
            cleanDeque(nums, deque, k, i);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

    private void cleanDeque(int[] nums, Deque<Integer> deque, int k, int i) {
        // rm element not in window
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }

        // rm slower element
        while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
            deque.removeLast();
        }
    }
}
