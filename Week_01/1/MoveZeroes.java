/**
 * 移动零:
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 优解参考:
 * - [官方题解](https://leetcode-cn.com/problems/move-zeroes/solution/)
 */
class MoveZeroes {

    /**
     * 不推荐
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public void solution1(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int nonZeroLen = 0;
        for(int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] != 0) {
                ++nonZeroLen;
                continue;
            }
            if (nonZeroLen == 0) {
                continue;
            }

            for (int j = i + 1; j < i + nonZeroLen + 1; ++j) {
                nums[j-1] = nums[j];
            }
            nums[i+nonZeroLen] = 0;
        }
    }

    /**
     * 推荐
     * 双指针(快慢指针):
     * 将问题转换为: 将所有非 0 元素置于数组前面，保持它们的相对顺序相同
     *
     * 慢指针之前的所有元素都是非零的。
     * 当前指针和慢速指针之间的所有元素都是零。
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public void solution2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                continue;
            }

            if (lastNonZeroIndex == i) {
                ++lastNonZeroIndex;
                continue;
            }

            nums[lastNonZeroIndex] = nums[i];
            nums[i] = 0;
            ++lastNonZeroIndex;
        }
    }
}