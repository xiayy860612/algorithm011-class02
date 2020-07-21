/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
class ValidBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归检查
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean isValidBST_1(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        if (lower != null && lower >= root.val) {
            return false;
        }

        if (upper != null && upper <= root.val) {
            return false;
        }

        return isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }

    /**
     * 二叉搜索树的中序遍历是有序排列的.
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST_2(TreeNode root) {
        return help(root);
    }

    private boolean help(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!help(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return help(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        Boolean result = new Solution().isValidBST_2(node);
        System.out.println(result);
    }
}