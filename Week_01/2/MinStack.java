import java.util.Stack;

/**
 * 最小栈:
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间O(1)内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 通过辅助栈, 以空间换时间.
 *
 * <a href="https://leetcode-cn.com/problems/min-stack/solution/zui-xiao-zhan-by-leetcode-solution/">LeetCode题解</a>
 */
class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>() {{
        push(Integer.MAX_VALUE);
    }};

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        return minStack.peek();
    }
}