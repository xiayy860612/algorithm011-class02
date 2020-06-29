/**
 * 盛水最多的容器:
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 面积 = 高 * 底 = min(ai, aj) * (j-i)
 *
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/solution/">LeetCode题解</a>
 */
class ContainerWithMostWater {

    /**
     * 推荐
     * 双指针, 使用双指针确定左右边界,
     * 通过左右边界向中间收敛
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int solution1(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int currentArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(currentArea, maxArea);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return maxArea;
    }

    /**
     * 遍历所有的情况, 找出最大值.
     *
     * 重点: 嵌套遍历整个数组
     * for (int i = 0; i < height.length-1; ++i) {
     *    for (int j = i + 1; j < height.length; ++j) {
     *      .....
     *    }
     * }
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public int solution2(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length-1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
    }
}