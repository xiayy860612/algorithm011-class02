import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效的括号:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/">LeetCode题解</a>
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/>优解</a>
 */
class ValidParentheses {
    /**
     * 基于栈的LIFO的特性进行校验括号
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean solution1(String s) {
        Map<Character, Character> parentheses = new HashMap<>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        // 加入哨兵
        Deque<Character> left = new LinkedList<>() {{
           addLast('?');
        }};
        for (char cur : s.toCharArray()) {
            if (cur == ' ') {
                continue;
            }

            if (parentheses.containsKey(cur)) {
                left.addLast(cur);
                continue;
            }
            // cur is right
            if (parentheses.getOrDefault(left.removeLast(), '?') != cur) {
                return false;
            }
        }
        return left.size() == 1;
    }
}