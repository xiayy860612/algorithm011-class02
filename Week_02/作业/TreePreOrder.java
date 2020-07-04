import java.util.*;

/**
 * N叉树的前序遍历:
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
class TreePreOrder {
    private static class Node {
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
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        for (Node child : root.children) {
            recursive(child, result);
        }
    }
}