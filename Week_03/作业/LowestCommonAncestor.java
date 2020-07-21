/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LowestCommonAncestor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     *
     * 时间复杂度: O(n)
     * 空间复杂度:O(n)
     */

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if ((l && r) || ((root.val == p.val || root.val == q.val) && (l || r))) {
            ans = root;
        }
        return l || r || (root.val == p.val || root.val == q.val);
    }
}