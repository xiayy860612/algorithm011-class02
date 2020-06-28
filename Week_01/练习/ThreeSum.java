import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和:
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * <a href="https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/">LeetCod官方题解e</a>
 *
 */
class ThreeSum {

    /**
     * 排序 + 双指针:
     * 对元素从小到大进行排序, 然后对b, c使用左右指针从两端的边界向中间收拢, 寻找b + c = -a
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     */
    public List<List<Integer>> solution1(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int first = 0; first < nums.length - 2; ++first) {
            if (nums[first] > 0) {
                break;
            }

            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum < 0) {
                    while (second < third && nums[second] == nums[++second]) ;
                } else if (sum > 0) {
                    while (second < third && nums[third] == nums[--third]) ;
                } else {
                    result.add(Arrays.<Integer>asList(nums[first], nums[second], nums[third]));
                    while (second < third && nums[second] == nums[++second]) ;
                    while (second < third && nums[third] == nums[--third]) ;
                }
            }
        }
        return result;
    }
}