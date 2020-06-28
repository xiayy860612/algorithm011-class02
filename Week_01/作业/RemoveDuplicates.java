/**
 * 删除排序数组中的重复项:
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 提示:
 * 数组是有序的，那么重复的元素一定会相邻
 *
 * - [LeetCode官方题解](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/)
 */
class RemoveDuplicates {
    /**
     * 快慢指针
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int solution1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int lastIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[lastIndex]) {
                continue;
            }
            nums[++lastIndex] = nums[i];
        }
        return lastIndex + 1;
    }
}