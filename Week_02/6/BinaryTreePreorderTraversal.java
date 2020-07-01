import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历: 根左右
 */
class BinaryTreePreorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 递归
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursive(root, result);
        return result;
    }

    private void recursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        recursive(root.left, result);
        recursive(root.right, result);
    }

}