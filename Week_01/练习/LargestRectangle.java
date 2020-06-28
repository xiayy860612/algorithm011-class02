import java.util.Stack;

/**
 * 柱状图中最大的矩形:
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * - [LeetCode官方题解](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/)
 * - [讲解清晰](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/)
 */
class LargestRectangle {

    /**
     * 单调栈:
     * 使用从小到大的栈存储右边界还未确定的元素,
     * 当遇到比栈顶元素小的元素时, 栈顶元素就有了右边界, 即栈顶元素不能再继续向右扩展.
     *
     * 宽度 = right - left - 1
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int solution1(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>() {{
            push(-1);
        }};
        int maxArea = 0;
        for(int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}