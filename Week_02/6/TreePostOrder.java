import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后序遍历:
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 */
class TreePostOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    /**
     * 递归
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public List<Integer> solution1(Node root) {
        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            recursive(child, result);
        }
        result.add(root.val);
    }

    /**
     * 栈+循环模拟递归
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public List<Integer> solution2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    stack.addLast(child);
                }
            }
        }
        return result;
    }
}