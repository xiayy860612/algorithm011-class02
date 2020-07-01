import java.util.*;

/**
 * N叉树的前序遍历:
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
class TreePreOrder {
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
     * 栈+循环模拟递归
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public List<Integer> solution2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<Integer> result = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);

            Collections.reverse(node.children);
            for (Node child : node.children) {
                if (child != null) {
                    stack.addLast(child);
                }
            }
        }
        return result;
    }
}